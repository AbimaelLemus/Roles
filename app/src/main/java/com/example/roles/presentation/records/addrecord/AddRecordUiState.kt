package com.example.roles.presentation.records.addrecord

data class AddRecordUiState(
    val name: String = "",
    val age: String = "",
    val educationLevel: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val nameError: String? = null,
    val ageError: String? = null,
    val educationLevelError: String? = null,
    val success: Boolean = false
)
