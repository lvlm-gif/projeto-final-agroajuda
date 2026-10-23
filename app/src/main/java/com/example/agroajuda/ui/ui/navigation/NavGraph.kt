package com.example.agroajuda.ui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.agroajuda.data.local.AgroAjudaDatabase
import com.example.agroajuda.data.repository.ProfissionalRepository
import com.example.agroajuda.ui.navigation.NavTarget
import com.example.agroajuda.ui.ui.features.TelaPrincipal
import com.example.agroajuda.ui.ui.features.TelaCadastro
import com.example.agroajuda.ui.ui.features.TelaDetalhes
import com.example.agroajuda.ui.ui.features.TelaConfirmacao
import com.example.agroajuda.ui.viewmodel.ProfissionalViewModel
import com.example.agroajuda.ui.viewmodel.ProfissionalViewModelFactory

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    
    // Inicialização do ViewModel com o Repository e Database existentes
    val database = AgroAjudaDatabase.getDatabase(context)
    val repository = ProfissionalRepository(database.profissionalDao())
    val factory = ProfissionalViewModelFactory(repository)
    val viewModel: ProfissionalViewModel = viewModel(factory = factory)

    NavHost(
        navController = navController,
        startDestination = NavTarget.Home.route
    ) {
        composable(NavTarget.Home.route) {
            TelaPrincipal(
                viewModel = viewModel,
                onCadastrarClick = {
                    navController.navigate(NavTarget.Cadastro.route)
                },
                onProfissionalClick = { profissionalId ->
                    navController.navigate(NavTarget.Detalhes.createRoute(profissionalId))
                }
            )
        }

        composable(NavTarget.Cadastro.route) {
            TelaCadastro(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = NavTarget.Detalhes.route,
            arguments = listOf(navArgument("profissionalId") { type = NavType.IntType })
        ) { backStackEntry ->
            val profissionalId = backStackEntry.arguments?.getInt("profissionalId") ?: 0
            val profissional by viewModel.getProfissionalById(profissionalId).collectAsState(initial = null)
            
            TelaDetalhes(
                profissional = profissional,
                onSolicitarClick = {
                    navController.navigate(NavTarget.Confirmacao.route)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(NavTarget.Confirmacao.route) {
            TelaConfirmacao(
                onBackClick = {
                    navController.navigate(NavTarget.Home.route) {
                        popUpTo(NavTarget.Home.route) { inclusive = true }
                    }
                }
            )
        }
    }
}
