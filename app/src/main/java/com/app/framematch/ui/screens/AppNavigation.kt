package com.app.framematch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.framematch.ui.screens.ClientDashboardScreen
import com.app.framematch.ui.screens.LoginScreen
import com.app.framematch.ui.screens.PhotographerDashboardScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController() // Initialize NavController

    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("loginScreen") {
            LoginScreen(navController = navController) // Passing NavController to LoginScreen
        }
        composable("photographerDashboard") {
            PhotographerDashboardScreen(navController = navController) // Passing NavController to PhotographerDashboardScreen
        }
        composable("clientDashboard") {
            ClientDashboardScreen(navController = navController) // Passing NavController to ClientDashboardScreen
        }
    }
}
