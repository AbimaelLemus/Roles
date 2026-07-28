package com.example.roles.presentation.records.localrecords

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.roles.domain.model.RegisterPerson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocalRecordsScreen(
    viewModel: LocalRecordsViewModel,
    isSupervisor: Boolean = false
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Registros locales")
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
                    PersonItem(
                        person = person,
                        isSupervisor = isSupervisor,
                        onDelete = {
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

@Composable
private fun PersonItem(
    person: RegisterPerson,
    isSupervisor: Boolean,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = person.name,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier.height(4.dp)
                )
                Text("Edad: ${person.age}")
                Text("Escolaridad: ${person.educationLevel}")
            }
            if (isSupervisor) {
                IconButton(
                    onClick = onDelete
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar"
                    )
                }
            }
        }
    }
}