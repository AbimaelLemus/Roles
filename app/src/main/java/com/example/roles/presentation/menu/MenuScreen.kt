package com.example.roles.presentation.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.roles.domain.model.Role

@Composable
fun MenuScreen(viewModel: MenuViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    when (uiState.role) {
        Role.SUPERVISOR -> {
            CurrentSession(role = Role.SUPERVISOR.name)
        }

        Role.OPERATOR -> {
            CurrentSession(role = Role.OPERATOR.name)
        }

        else -> {
            //Regresar al login
        }
    }
}

@Composable
private fun CurrentSession(role: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Menu Principal: $role")
    }
}