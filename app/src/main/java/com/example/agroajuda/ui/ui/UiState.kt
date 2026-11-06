package com.example.agroajuda.ui.ui

import com.example.agroajuda.model.Profissional

/**
 * Representa os diferentes estados da interface do usuário (UI) 
 * no fluxo de carregamento de dados dos profissionais.
 *
 * - [Carregando]: Indica que uma operação assíncrona está em andamento.
 * - [Vazio]: Indica que a consulta foi concluída, mas não há dados para exibir.
 * - [Erro]: Captura falhas e fornece uma mensagem descritiva do problema.
 * - [Sucesso]: Fornece a lista de profissionais recuperada com êxito.
 */
sealed interface UiState {
    data object Carregando : UiState
    data object Vazio : UiState
    data class Erro(val mensagem: String) : UiState
    data class Sucesso(val profissionais: List<Profissional>) : UiState
}
