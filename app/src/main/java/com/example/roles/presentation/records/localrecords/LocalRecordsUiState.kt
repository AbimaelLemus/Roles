package com.example.roles.presentation.records.localrecords

import com.example.roles.domain.model.RegisterPerson

data class LocalRecordsUiState(
    val persons: List<RegisterPerson> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val personToDelete: RegisterPerson? = null
)
