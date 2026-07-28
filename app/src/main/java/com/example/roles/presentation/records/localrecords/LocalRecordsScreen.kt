package com.example.roles.presentation.records.localrecords

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.roles.presentation.components.AppTopBar
import com.example.roles.presentation.components.PersonCard

@Composable
fun LocalRecordsScreen(
    navController: NavController,
    viewModel: LocalRecordsViewModel,
    isSupervisor: Boolean = false
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Registros locales",
                onBack = {
                    navController.navigateUp()
                }
            )
        }
    ) { padding ->
        if (uiState.persons.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No existen registros")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ) {

                items(uiState.persons) { person ->
                    PersonCard(person = person,
                        showDeleteButton = isSupervisor,
                        onDeleteClick = {
                            viewModel.showDeleteDialog(person)
                        }
                    )
                }
            }
        }
    }

    val personToDelete = uiState.personToDelete

    if (personToDelete != null) {

        AlertDialog(
            onDismissRequest = {
                viewModel.dismissDeleteDialog()
            },
            title = {
                Text("Eliminar registro")
            },
            text = {
                Text(
                    "¿Deseas eliminar a ${personToDelete.name}?"
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.deletePerson(
                            personToDelete
                        )
                    }
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        viewModel.dismissDeleteDialog()
                    }
                ) {
                    Text("Cancelar")
                }
            }
        )
    }
}