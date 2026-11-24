package com.example.agroajuda.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.agroajuda.data.repository.SolicitacaoRepository
import com.example.agroajuda.model.Solicitacao
import com.example.agroajuda.ui.ui.SolicitacaoUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * ViewModel responsável por gerenciar a lógica de interface das solicitações.
 * Realiza a ponte entre a UI e o SolicitacaoRepository.
 */
class SolicitacaoViewModel(private val repository: SolicitacaoRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<SolicitacaoUiState>(SolicitacaoUiState.Carregando)
    val uiState: StateFlow<SolicitacaoUiState> = _uiState.asStateFlow()

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
            repository.allSolicitacoes
                .onStart { _uiState.value = SolicitacaoUiState.Carregando }
                .catch { _uiState.value = SolicitacaoUiState.Erro("erro_carregamento_solicitacoes") }
                .collect { solicitacoes ->
                    _uiState.value = if (solicitacoes.isEmpty()) {
                        SolicitacaoUiState.Vazio
                    } else {
                        SolicitacaoUiState.Sucesso(solicitacoes)
                    }
                }
        }
    }

    /**
     * StateFlow que expõe a lista de todas as solicitações para a UI.
     * Utiliza stateIn para converter o Flow do repositório em um estado observável pelo Compose.
     * Mantida para compatibilidade com as telas existentes.
     */
    val allSolicitacoes: StateFlow<List<Solicitacao>> = repository.allSolicitacoes
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    /**
     * Retorna um fluxo de solicitações filtrado por um profissional específico.
     */
    fun getSolicitacoesByProfissional(profissionalId: Int): Flow<List<Solicitacao>> {
        return repository.getSolicitacoesByProfissional(profissionalId)
    }

    /**
     * Retorna um fluxo para uma solicitação específica baseada no ID.
     */
    fun getSolicitacaoById(id: Int): Flow<Solicitacao?> {
        return repository.getSolicitacaoById(id)
    }

    /**
     * Insere uma nova solicitação ou atualiza uma existente.
     * A operação é executada em uma coroutine dentro do escopo do ViewModel.
     * @param solicitacao A entidade a ser salva.
     * @param onComplete Callback executado após a conclusão da operação.
     */
    fun insert(solicitacao: Solicitacao, onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                repository.insert(solicitacao)
                onComplete()
            } catch (e: IOException) {
                _uiState.value = SolicitacaoUiState.Erro("erro_conexao_banco")
            } catch (e: Exception) {
                _uiState.value = SolicitacaoUiState.Erro("erro_insercao_solicitacao")
            }
        }
    }

    /**
     * Exclui uma solicitação pelo seu ID.
     * @param id O identificador da solicitação a ser removida.
     * @param onComplete Callback executado após a conclusão da operação.
     */
    fun delete(id: Int, onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            try {
                repository.deleteById(id)
                onComplete()
            } catch (e: IOException) {
                _uiState.value = SolicitacaoUiState.Erro("erro_conexao_banco")
            } catch (e: Exception) {
                _uiState.value = SolicitacaoUiState.Erro("erro_exclusao_solicitacao")
            }
        }
    }

    /**
     * Atualiza o status de uma solicitação.
     * @param id O identificador da solicitação.
     * @param novoStatus O novo status a ser definido.
     */
    fun updateStatus(id: Int, novoStatus: String) {
        viewModelScope.launch {
            try {
                repository.updateStatus(id, novoStatus)
            } catch (e: IOException) {
                _uiState.value = SolicitacaoUiState.Erro("erro_conexao_banco")
            } catch (e: Exception) {
                _uiState.value = SolicitacaoUiState.Erro("erro_atualizacao_status")
            }
        }
    }
}

/**
 * Factory para instanciar o SolicitacaoViewModel com seu repositório dependente.
 */
class SolicitacaoViewModelFactory(private val repository: SolicitacaoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SolicitacaoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SolicitacaoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
