package com.example.agroajuda.ui.ui

import com.example.agroajuda.model.Solicitacao

/**
 * Representa os estados da interface para o fluxo de solicitações.
 */
sealed interface SolicitacaoUiState {
    data object Carregando : SolicitacaoUiState
    data object Vazio : SolicitacaoUiState
    data class Erro(val mensagem: String) : SolicitacaoUiState
    data class Sucesso(val solicitacoes: List<Solicitacao>) : SolicitacaoUiState
}
