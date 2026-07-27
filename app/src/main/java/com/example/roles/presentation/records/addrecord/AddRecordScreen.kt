package com.example.roles.presentation.records.addrecord

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AddRecordScreen(viewModel: AddRecordViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText(message = "Registrar persona")
        MySpacer(32)
        OutlinedTextField(
            value = uiState.name,
            onValueChange = viewModel::onNameChange,
            label = {
                Text("Nombre")
            },
            modifier = Modifier.fillMaxWidth()
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
            )
        )
        MySpacer(spacer = 8)
        OutlinedTextField(
            value = uiState.educationLevel,
            onValueChange = viewModel::onEducationLevelChange,
            label = {
                Text("Nivel de estudio")
            },
            modifier = Modifier.fillMaxWidth()
        )
        MySpacer(spacer = 32)
        Button(onClick = {
            viewModel.saveRecord()
        }, modifier = Modifier.fillMaxWidth()) {
            MyText(message = "Guardar registro")
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