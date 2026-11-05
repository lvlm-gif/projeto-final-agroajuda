package com.example.agroajuda.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.agroajuda.data.local.AgroAjudaDatabase
import com.example.agroajuda.data.repository.ProfissionalRepository
import com.example.agroajuda.data.repository.SolicitacaoRepository
import com.example.agroajuda.model.Solicitacao
import com.example.agroajuda.ui.ui.features.*
import com.example.agroajuda.ui.viewmodel.ProfissionalViewModel
import com.example.agroajuda.ui.viewmodel.ProfissionalViewModelFactory
import com.example.agroajuda.ui.viewmodel.SolicitacaoViewModel
import com.example.agroajuda.ui.viewmodel.SolicitacaoViewModelFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val database = AgroAjudaDatabase.getDatabase(context)
    
    val profissionalRepository = ProfissionalRepository(database.profissionalDao())
    val profissionalFactory = ProfissionalViewModelFactory(profissionalRepository)
    val profissionalViewModel: ProfissionalViewModel = viewModel(factory = profissionalFactory)

    val solicitacaoRepository = SolicitacaoRepository(database.solicitacaoDao())
    val solicitacaoFactory = SolicitacaoViewModelFactory(solicitacaoRepository)
    val solicitacaoViewModel: SolicitacaoViewModel = viewModel(factory = solicitacaoFactory)

    NavHost(
        navController = navController,
        startDestination = NavTarget.Login.route
    ) {
        composable(NavTarget.Login.route) {
            TelaLogin(
                onLoginClick = {
                    navController.navigate(NavTarget.Home.route) {
                        popUpTo(NavTarget.Login.route) { inclusive = true }
                    }
                },
                onCadastroClick = {
                    navController.navigate(NavTarget.CadastroCliente.route)
                }
            )
        }

        composable(NavTarget.Home.route) {
            TelaPrincipal(
                viewModel = profissionalViewModel,
                onCadastrarClick = {
                    navController.navigate(NavTarget.Cadastro.route)
                },
                onProfissionalClick = { profissionalId ->
                    navController.navigate(NavTarget.Detalhes.createRoute(profissionalId))
                },
                onStatusClick = {
                    navController.navigate(NavTarget.StatusSolicitacao.route)
                }
            )
        }

        composable(NavTarget.Cadastro.route) {
            TelaCadastro(
                viewModel = profissionalViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(NavTarget.CadastroCliente.route) {
            TelaCadastroCliente(
                onCadastroFinalizado = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = NavTarget.Detalhes.route,
            arguments = listOf(navArgument("profissionalId") { type = NavType.IntType })
        ) { backStackEntry ->
            val profissionalId = backStackEntry.arguments?.getInt("profissionalId") ?: 0
            val profissional by profissionalViewModel.getProfissionalById(profissionalId).collectAsState(initial = null)

            TelaDetalhes(
                profissional = profissional,
                onSolicitarClick = {
                    navController.navigate(NavTarget.DescricaoSolicitacao.createRoute(profissionalId))
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = NavTarget.DescricaoSolicitacao.route,
            arguments = listOf(navArgument("profissionalId") { type = NavType.IntType })
        ) { backStackEntry ->
            val profissionalId = backStackEntry.arguments?.getInt("profissionalId") ?: 0
            
            TelaDescricaoSolicitacao(
                onEnviarClick = { descricao ->
                    navController.navigate(NavTarget.Confirmacao.createRoute(profissionalId, descricao))
                }
            )
        }

        composable(
            route = NavTarget.Confirmacao.route,
            arguments = listOf(
                navArgument("profissionalId") { type = NavType.IntType },
                navArgument("descricao") { 
                    type = NavType.StringType
                    nullable = true
                    defaultValue = ""
                }
            )
        ) { backStackEntry ->
            val profissionalId = backStackEntry.arguments?.getInt("profissionalId") ?: 0
            val descricao = backStackEntry.arguments?.getString("descricao") ?: ""
            val profissional by profissionalViewModel.getProfissionalById(profissionalId).collectAsState(initial = null)
            
            TelaConfirmacao(
                profissional = profissional,
                descricao = descricao,
                onBackClick = {
                    navController.navigate(NavTarget.Home.route) {
                        popUpTo(NavTarget.Home.route) { inclusive = true }
                    }
                }
            )
        }

        composable(NavTarget.StatusSolicitacao.route) {
            TelaStatusSolicitacao(
                solicitacaoViewModel = solicitacaoViewModel,
                profissionalViewModel = profissionalViewModel,
                onBackClick = {
                    navController.popBackStack()
                },
                onHomeClick = {
                    navController.navigate(NavTarget.Home.route) {
                        popUpTo(NavTarget.Home.route) { inclusive = true }
                    }
                }
            )
        }
    }
}
