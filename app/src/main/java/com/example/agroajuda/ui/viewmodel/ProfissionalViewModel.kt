package com.example.agroajuda.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.agroajuda.data.repository.ProfissionalRepository
import com.example.agroajuda.model.Profissional
import com.example.agroajuda.ui.ui.UiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProfissionalViewModel(private val repository: ProfissionalRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Carregando)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private var flowJob: Job? = null

    init {
        carregar()
    }

    /**
     * Inicia ou reinicia a coleta de dados do repositório.
     * Garante que falhas de carregamento possam ser repetidas pela interface através de uma nova tentativa.
     */
    fun carregar() {
        flowJob?.cancel()
        flowJob = viewModelScope.launch {
            repository.allProfissionais
                .onStart { _uiState.value = UiState.Carregando }
                .catch { _uiState.value = UiState.Erro("erro_carregamento_profissionais") }
                .collect { profissionais ->
                    _uiState.value = if (profissionais.isEmpty()) {
                        UiState.Vazio
                    } else {
                        UiState.Sucesso(profissionais)
                    }
                }
        }
    }

    /**
     * Propriedade mantida para compatibilidade com as telas existentes que ainda observam a lista direta.
     */
    val allProfissionais: StateFlow<List<Profissional>> = repository.allProfissionais
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun getProfissionalById(id: Int): Flow<Profissional?> {
        return repository.getProfissionalById(id)
    }

    /**
     * Insere um novo profissional e trata o fluxo de sucesso e erro.
     * Caso ocorra uma falha na persistência, o estado de erro é comunicado à interface.
     */
    fun insert(profissional: Profissional, onComplete: () -> Unit) {
        viewModelScope.launch {
            try {
                repository.insert(profissional)
                onComplete()
            } catch (e: Exception) {
                _uiState.value = UiState.Erro("erro_insercao_profissional")
            }
        }
    }
}

class ProfissionalViewModelFactory(private val repository: ProfissionalRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfissionalViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfissionalViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
