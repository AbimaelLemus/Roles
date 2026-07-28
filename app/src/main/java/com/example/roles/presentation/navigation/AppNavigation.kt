package com.example.roles.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roles.data.session.SessionManager
import com.example.roles.di.AppContainer
import com.example.roles.presentation.login.LoginScreen
import com.example.roles.presentation.login.LoginViewModel
import com.example.roles.presentation.menu.MenuScreen
import com.example.roles.presentation.menu.MenuViewModel
import com.example.roles.presentation.records.addrecord.AddRecordScreen
import com.example.roles.presentation.records.addrecord.AddRecordViewModel
import com.example.roles.presentation.records.addrecord.AddRecordViewModelFactory
import com.example.roles.presentation.records.localrecords.LocalRecordsScreen
import com.example.roles.presentation.records.localrecords.LocalRecordsViewModel
import com.example.roles.presentation.records.localrecords.LocalRecordsViewModelFactory
import com.example.roles.presentation.records.remoterecords.RemoteRecordsScreen
import com.example.roles.presentation.records.remoterecords.RemoteRecordsViewModel
import com.example.roles.presentation.records.remoterecords.RemoteRecordsViewModelFactory

@Composable
fun AppNavigation(
    container: AppContainer
) {
    val navController = rememberNavController()

    val starDestinacion =
        if (SessionManager.currentSession != null) {
            Screen.Menu.route
        } else {
            Screen.Login.route
        }

    NavHost(
        navController,
        startDestination = starDestinacion
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController, viewModel = LoginViewModel())
        }
        composable(Screen.Menu.route) {
            MenuScreen(navController = navController, viewModel = MenuViewModel())
        }
        composable(Screen.AddRecord.route) {
            val viewModel: AddRecordViewModel = viewModel(
                factory = AddRecordViewModelFactory(
                    container.useCases
                )
            )
            AddRecordScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.LocalRecords.route) {

            val viewModel: LocalRecordsViewModel = viewModel(
                factory = LocalRecordsViewModelFactory(
                    container.useCases
                )
            )

            LocalRecordsScreen(
                navController = navController,
                viewModel = viewModel,
                isSupervisor = SessionManager.isSupervisor
            )
        }
        composable(Screen.RemoteRecords.route) {
            val viewModel: RemoteRecordsViewModel = viewModel(
                factory = RemoteRecordsViewModelFactory(
                    container.useCases
                )
            )
            RemoteRecordsScreen(navController = navController, viewModel = viewModel)
        }
    }

}