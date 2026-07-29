package com.example.roles.presentation.records.addrecord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.usecase.InsertRegisterPersonUseCase
import com.example.roles.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRecordViewModel @Inject constructor(
    private val insertRegisterPersonUseCase: InsertRegisterPersonUseCase
) : ViewModel() {
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
        val state = _uiState.value
        var hasError = false
        var nameError: String? = null
        var ageError: String? = null
        var educationError: String? = null

        if (state.name.trim().length < 3) {
            nameError = "Mínimo 3 caracteres"
            hasError = true
        }

        val age = state.age.toIntOrNull()

        if (age == null || age !in 1..120) {
            ageError = "Edad inválida"
            hasError = true
        }

        if (state.educationLevel.isBlank()) {
            educationError = "Campo obligatorio"
            hasError = true
        }

        _uiState.update {
            it.copy(
                nameError = nameError,
                ageError = ageError,
                educationLevelError = educationError
            )
        }

        if (hasError) return

        viewModelScope.launch {
            try {

                _uiState.update {
                    it.copy(
                        isLoading = true
                    )
                }

                insertRegisterPersonUseCase(
                    RegisterPerson(
                        name = state.name,
                        age = age!!,
                        educationLevel = state.educationLevel
                    )
                )

                _uiState.update {
                    AddRecordUiState(
                        success = true
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        error = "No fue posible guardar el registro",
                        isLoading = false
                    )
                }
            }
        }
    }
    fun onSuccessHandled() {
        _uiState.update {
            it.copy(success = false)
        }
    }
}