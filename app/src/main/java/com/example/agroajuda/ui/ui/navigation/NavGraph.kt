
package com.example.agroajuda.ui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agroajuda.ui.ui.features.TelaPrincipal
import com.example.agroajuda.ui.ui.features.TelaCadastro
import com.example.agroajuda.ui.ui.features.TelaDetalhes
import com.example.agroajuda.ui.ui.features.TelaConfirmacao

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavTarget.Home.route
    ) {
        composable(NavTarget.Home.route) {
            TelaPrincipal(
                onCadastrarClick = {
                    navController.navigate(NavTarget.Cadastro.route)
                },
                onProfissionalClick = {
                    navController.navigate(NavTarget.Detalhes.route)
                }
            )
        }

        composable(NavTarget.Cadastro.route) {
            TelaCadastro()
        }

        composable(NavTarget.Detalhes.route) {
            TelaDetalhes(
                onSolicitarClick = {
                    navController.navigate(NavTarget.Confirmacao.route)
                }
            )
        }

        composable(NavTarget.Confirmacao.route) {
            TelaConfirmacao()
        }
    }
}