//package com.app.framematch.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import androidx.navigation.navArgument
//import com.app.framematch.ui.screens.*
//
//sealed class Screen(val route: String) {
//    object RoleSelection : Screen("roleSelection")
//    object Login : Screen("login/{userRole}") {
//        fun createRoute(userRole: String) = "login/$userRole"
//    }
//    object Dashboard : Screen("dashboard/{userRole}") {
//        fun createRoute(userRole: String) = "dashboard/$userRole"
//    }
//}
//
//@Composable
//fun NavGraph(navController: NavController) {
//    NavHost(navController = navController, startDestination = Screen.RoleSelection.route) {
//        composable(Screen.RoleSelection.route) {
//            RoleSelectionScreen(navController = navController)
//        }
//        composable(
//            route = Screen.Login.route,
//            arguments = listOf(navArgument("userRole") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val userRole = backStackEntry.arguments?.getString("userRole")
//            when (userRole) {
//                "Photographer" -> PhotographerLoginScreen(navController = navController)
//                "Client" -> ClientLoginScreen(navController = navController)
//                else -> Text("Error: Unknown user role")
//            }
//        }
//        composable(
//            route = Screen.Dashboard.route,
//            arguments = listOf(navArgument("userRole") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val userRole = backStackEntry.arguments?.getString("userRole")
//            when (userRole) {
//                "Photographer" -> PhotographerDashboardScreen(navController = navController)
//                "Client" -> ClientDashboardScreen(navController = navController)
//                else -> Text("Error: Unknown user role")
//            }
//        }
//    }
//}
