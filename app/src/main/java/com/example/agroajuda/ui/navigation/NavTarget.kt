package com.example.agroajuda.ui.navigation

sealed class NavTarget(val route: String) {

    data object Home : NavTarget("home")

    data object Cadastro : NavTarget("cadastro")

    data object Detalhes : NavTarget("detalhes/{profissionalId}") {
        fun createRoute(profissionalId: Int) = "detalhes/$profissionalId"
    }

    data object Confirmacao : NavTarget("confirmacao")

    data object StatusSolicitacao : NavTarget("status_solicitacao")
}
