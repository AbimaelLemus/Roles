package com.example.roles.presentation.records.addrecord

data class AddRecordUiState(
    val name: String = "",
    val age: String = "",
    val educationLevel: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)
