package com.example.roles.presentation.records.localrecords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.usecase.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocalRecordsViewModel(
    private val useCases: UseCases
) : ViewModel() {

    private val _uiState = MutableStateFlow(LocalRecordsUiState())

    val uiState = _uiState.asStateFlow()

    init {
        loadRecords()
    }

    private fun loadRecords() {
        viewModelScope.launch {
            useCases
                .getRegisterPersons()
                .collect { persons ->

                    _uiState.update {
                        it.copy(
                            persons = persons
                        )
                    }
                }
        }
    }

    fun deletePerson(person: RegisterPerson) {
        viewModelScope.launch {
            useCases.deleteRegisterPerson(person)
            dismissDeleteDialog()
        }
    }

    fun showDeleteDialog(
        person: RegisterPerson
    ) {
        _uiState.update {
            it.copy(
                personToDelete = person
            )
        }
    }

    fun dismissDeleteDialog() {
        _uiState.update {
            it.copy(
                personToDelete = null
            )
        }
    }

}