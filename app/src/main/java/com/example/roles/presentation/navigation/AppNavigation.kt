package com.example.roles.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roles.presentation.login.LoginScreen
import com.example.roles.presentation.login.LoginViewModel
import com.example.roles.presentation.menu.MenuScreen
import com.example.roles.presentation.menu.MenuViewModel
import com.example.roles.presentation.records.addrecord.AddRecordScreen
import com.example.roles.presentation.records.addrecord.AddRecordViewModel
import com.example.roles.presentation.records.localrecords.LocalRecordsScreen
import com.example.roles.presentation.records.remoterecords.RemoteRecordsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController, viewModel = LoginViewModel())
        }
        composable(Screen.Menu.route) {
            MenuScreen(navController = navController, viewModel = MenuViewModel())
        }
        composable(Screen.AddRecord.route) {
            AddRecordScreen(AddRecordViewModel())
        }
        composable(Screen.LocalRecords.route) {
            LocalRecordsScreen()
        }
        composable(Screen.RemoteRecords.route) {
            RemoteRecordsScreen()
        }
    }

}