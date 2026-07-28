package com.example.roles.presentation.records.addrecord

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roles.presentation.components.AppTopBar

@Composable
fun AddRecordScreen(navController: NavController, viewModel: AddRecordViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(
        uiState.success
    ) {
        if (uiState.success) {
            Toast.makeText(context, "Registro guardado", Toast.LENGTH_SHORT).show()
            navController.navigateUp()
            viewModel.onSuccessHandled()
        }
    }

    LaunchedEffect(uiState.error) {
        uiState.error?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        topBar = {
            AppTopBar(title = "Registrar persona",
                onBack = {
                    navController.navigateUp()
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MySpacer(32)
            OutlinedTextField(
                value = uiState.name,
                onValueChange = viewModel::onNameChange,
                label = {
                    Text("Nombre")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = uiState.nameError != null,
                supportingText = {
                    uiState.nameError?.let {
                        Text(it)
                    }
                }
            )
            MySpacer(spacer = 8)
            OutlinedTextField(
                value = uiState.age,
                onValueChange = viewModel::onAgeChange,
                label = {
                    Text("Edad")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                isError = uiState.ageError != null,
                supportingText = {
                    uiState.ageError?.let {
                        Text(it)
                    }
                }
            )
            MySpacer(spacer = 8)
            OutlinedTextField(
                value = uiState.educationLevel,
                onValueChange = viewModel::onEducationLevelChange,
                label = {
                    Text("Nivel de estudio")
                },
                modifier = Modifier.fillMaxWidth(),
                isError = uiState.educationLevelError != null,
                supportingText = {
                    uiState.educationLevelError?.let {
                        Text(it)
                    }
                }
            )
            MySpacer(spacer = 32)
            Button(
                onClick = {
                    viewModel.saveRecord()
                },
                enabled = !uiState.isLoading,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    MyText(message = "Guardar registro")
                }
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