package com.example.roles.presentation.records.addrecord

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddRecordViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AddRecordUiState())
    val uiState: StateFlow<AddRecordUiState> = _uiState.asStateFlow()

    fun onNameChange(name: String) {
        _uiState.value = _uiState.value.copy(
            name = name
        )
    }

    fun onAgeChange(age: String) {
        _uiState.value = _uiState.value.copy(
            age = age
        )
    }

    fun onEducationLevelChange(educationLevel: String) {
        _uiState.value = _uiState.value.copy(
            educationLevel = educationLevel
        )
    }

    fun saveRecord() {

    }

}