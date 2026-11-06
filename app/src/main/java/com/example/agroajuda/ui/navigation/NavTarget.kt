package com.example.agroajuda.ui.navigation

import android.net.Uri

sealed class NavTarget(val route: String) {

    data object Login : NavTarget("login")

    data object Home : NavTarget("home")

    data object Cadastro : NavTarget("cadastro")

    data object CadastroCliente : NavTarget("cadastro_cliente")

    data object Detalhes : NavTarget("detalhes/{profissionalId}") {
        fun createRoute(profissionalId: Int) = "detalhes/$profissionalId"
    }

    data object DescricaoSolicitacao : NavTarget("descricao_solicitacao/{profissionalId}") {
        fun createRoute(profissionalId: Int) = "descricao_solicitacao/$profissionalId"
    }

    data object Confirmacao : NavTarget("confirmacao/{profissionalId}?descricao={descricao}") {
        fun createRoute(profissionalId: Int, descricao: String) = 
            "confirmacao/$profissionalId?descricao=${Uri.encode(descricao)}"
    }

    data object StatusSolicitacao : NavTarget("status_solicitacao")
}
