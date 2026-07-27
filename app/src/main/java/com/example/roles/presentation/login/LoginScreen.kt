package com.example.roles.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roles.presentation.navigation.Screen

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = uiState.isLoggedIn) {
        if (uiState.isLoggedIn) {
            navController.navigate(Screen.Menu.route) {
                popUpTo(Screen.Login.route) {
                    inclusive = true
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText()
        MYSpacer(16)
        OutlinedTextField(
            value = uiState.username,
            onValueChange = viewModel::onUsernameChange,
            label = {
                Text("Usuario")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        MYSpacer(16)
        OutlinedTextField(
            value = uiState.password,
            onValueChange = viewModel::onPasswordChange,
            label = {
                Text("Contraseña")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        MYSpacer(32)
        Button(
            onClick = {
                viewModel.login()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !uiState.isLoading
        ) {
            if (uiState.isLoading) {
                CircularProgressIndicator()
            } else {
                Text("Iniciar sesión")
            }

        }

        uiState.error?.let {
            MYSpacer(16)
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )

        }
    }
}

@Composable
private fun MYSpacer(spacer: Int) {
    Spacer(modifier = Modifier.height(spacer.dp))
}

@Composable
fun MyText() {
    Text(text = "Iniciar sesión")
}
