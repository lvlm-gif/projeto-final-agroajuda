package com.example.agroajuda.ui.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavTarget.Home.route
    ) {
        composable(NavTarget.Home.route) {
            Text(text = "Agroajuda")
        }
    }
}