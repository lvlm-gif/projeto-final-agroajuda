package com.example.agroajuda.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.agroajuda.data.repository.ClienteRepository
import com.example.agroajuda.model.Cliente
import com.example.agroajuda.ui.ui.ClienteUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * ViewModel responsável por gerenciar a lógica de interface dos clientes.
 * Segue o padrão de estados de UI estabelecido no projeto.
 */
class ClienteViewModel(private val repository: ClienteRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<ClienteUiState>(ClienteUiState.Carregando)
    val uiState: StateFlow<ClienteUiState> = _uiState.asStateFlow()

    private var flowJob: Job? = null

    init {
        carregar()
    }

    /**
     * Inicia ou reinicia a coleta de dados do repositório.
     * Permite que falhas de carregamento sejam repetidas pela interface.
     */
    fun carregar() {
        flowJob?.cancel()
        flowJob = viewModelScope.launch {
            repository.allClientes
                .onStart { _uiState.value = ClienteUiState.Carregando }
                .catch { _uiState.value = ClienteUiState.Erro("erro_carregamento_clientes") }
                .collect { clientes ->
                    _uiState.value = if (clientes.isEmpty()) {
                        ClienteUiState.Vazio
                    } else {
                        ClienteUiState.Sucesso(clientes)
                    }
                }
        }
    }

    /**
     * Mantida para compatibilidade com observadores diretos da lista.
     */
    val allClientes: StateFlow<List<Cliente>> = repository.allClientes
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    /**
     * Insere um novo cliente e trata possíveis erros de persistência.
     */
    fun insert(cliente: Cliente) {
        viewModelScope.launch {
            try {
                repository.insert(cliente)
            } catch (e: IOException) {
                _uiState.value = ClienteUiState.Erro("erro_conexao_banco")
            } catch (e: Exception) {
                _uiState.value = ClienteUiState.Erro("erro_insercao_cliente")
            }
        }
    }

    /**
     * Remove um cliente e trata possíveis erros de persistência.
     */
    fun delete(cliente: Cliente) {
        viewModelScope.launch {
            try {
                repository.delete(cliente)
            } catch (e: IOException) {
                _uiState.value = ClienteUiState.Erro("erro_conexao_banco")
            } catch (e: Exception) {
                _uiState.value = ClienteUiState.Erro("erro_exclusao_cliente")
            }
        }
    }
}

/**
 * Factory para instanciar o ClienteViewModel com seu repositório.
 */
class ClienteViewModelFactory(private val repository: ClienteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClienteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ClienteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
