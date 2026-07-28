package com.example.roles.presentation.records.addrecord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.usecase.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddRecordViewModel(
    private val useCases: UseCases
) : ViewModel() {
    private val _uiState = MutableStateFlow(AddRecordUiState())
    val uiState: StateFlow<AddRecordUiState> = _uiState.asStateFlow()

    /*private val addRecordViewModel by viewModels<AddRecordViewModel> {
        AddRecordViewModelFactory(
            container.useCases
        )
    }*/

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
        val state = _uiState.value

        if (
            state.name.isBlank() ||
            state.age.isBlank() ||
            state.educationLevel.isBlank()
        ) {
            return
        }
        viewModelScope.launch {

            useCases.insertRegisterPerson(
                RegisterPerson(
                    name = uiState.value.name,
                    age = uiState.value.age.toInt(),
                    educationLevel = uiState.value.educationLevel
                )
            )
        }
    }

}