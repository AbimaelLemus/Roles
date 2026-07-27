package com.example.roles.presentation.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screen(viewModel = LoginViewModel())
        }
    }

    @Composable
    fun Screen(viewModel: LoginViewModel) {
        val uiState by viewModel.uiState.collectAsState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            mSpacer(16)
            OutlinedTextField(
                value = uiState.username,
                onValueChange = viewModel::onUsernameChange,
                label = {
                    Text("Usuario")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            mSpacer(16)
            OutlinedTextField(
                value = uiState.password,
                onValueChange = viewModel::onPasswordChange,
                label = {
                    Text("Contraseña")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            mSpacer(32)
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
                mSpacer(16)
                Text(
                    text = it,
                    color = MaterialTheme.colorScheme.error
                )

            }
        }
    }

    @Composable
    private fun mSpacer(spacer: Int) {
        Spacer(modifier = Modifier.height(spacer.dp))
    }

    @Composable
    fun Title() {
        Text(text = "Iniciar sesión")
    }
}
