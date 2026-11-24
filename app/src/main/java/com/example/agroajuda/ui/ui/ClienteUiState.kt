package com.example.agroajuda.ui.ui

import com.example.agroajuda.model.Cliente

/**
 * Representa os estados da interface para o fluxo de clientes.
 */
sealed interface ClienteUiState {
    data object Carregando : ClienteUiState
    data object Vazio : ClienteUiState
    data class Erro(val mensagem: String) : ClienteUiState
    data class Sucesso(val clientes: List<Cliente>) : ClienteUiState
}
