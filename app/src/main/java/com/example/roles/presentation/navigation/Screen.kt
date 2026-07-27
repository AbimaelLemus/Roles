package com.example.roles.presentation.navigation

sealed class Screen ( val route: String ){
    data object Login: Screen("login")
    data object Menu : Screen("menu")
    data object AddRecord : Screen("add_record")
    data object LocalRecords : Screen("local_records")
    data object RemoteRecords : Screen("remote_records")
}