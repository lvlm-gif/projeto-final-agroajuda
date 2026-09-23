package com.example.agroajuda.ui.ui.navigation

sealed class NavTarget(val route: String) {

    data object Home : NavTarget("home")
}