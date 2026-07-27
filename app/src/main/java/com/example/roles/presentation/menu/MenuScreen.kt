package com.example.roles.presentation.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roles.domain.model.Role
import com.example.roles.presentation.navigation.Screen

@Composable
fun MenuScreen(navController: NavController, viewModel: MenuViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    when (uiState.role) {
        Role.SUPERVISOR -> {
            CurrentSession(role = Role.SUPERVISOR, navController)
        }

        Role.OPERATOR -> {
            CurrentSession(role = Role.OPERATOR, navController)
        }

        else -> {
            //Regresar al login
        }
    }
}

@Composable
private fun CurrentSession(role: Role, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText(message = role.name)

        MySpacer(32)
        if (role == Role.OPERATOR) {
            Button(onClick = {
                navController.navigate(Screen.AddRecord.route) {
                    popUpTo(Screen.Menu.route) {
                        inclusive = true
                    }
                }
            }, modifier = Modifier.fillMaxWidth()) {
                MyText(message = "Registrar persona")
            }
        }

        MySpacer(8)
        Button(onClick = {
            navController.navigate(Screen.LocalRecords.route) {
                popUpTo(Screen.Menu.route) {
                    inclusive = true
                }
            }
        }, modifier = Modifier.fillMaxWidth()) {
            MyText(message = "Registros locales")
        }

        if (role == Role.OPERATOR) {
            MySpacer(8)
            Button(onClick = {
                navController.navigate(Screen.RemoteRecords.route) {
                    popUpTo(Screen.Menu.route) {
                        inclusive = true
                    }
                }
            }, modifier = Modifier.fillMaxWidth()) {
                MyText(message = "Registros remotos")
            }
        }
    }


}

@Composable
private fun MySpacer(spacer: Int) {
    Spacer(modifier = Modifier.height(spacer.dp))
}

@Composable
fun MyText(message: String) {
    Text(text = message)
}