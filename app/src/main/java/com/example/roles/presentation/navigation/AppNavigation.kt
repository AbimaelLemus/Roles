package com.example.roles.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roles.presentation.login.LoginScreen
import com.example.roles.presentation.login.LoginViewModel
import com.example.roles.presentation.menu.MenuScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController, viewModel = LoginViewModel())
        }
        composable(Screen.Menu.route) {
            MenuScreen()
        }
    }

}