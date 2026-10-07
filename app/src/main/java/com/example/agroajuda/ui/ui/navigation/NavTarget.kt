package com.example.agroajuda.ui.ui.navigation

sealed class NavTarget(val route: String) {

    data object Home : NavTarget("home")

    data object Cadastro : NavTarget("cadastro")

    data object Detalhes : NavTarget("detalhes")

    data object Confirmacao : NavTarget("confirmacao")
}