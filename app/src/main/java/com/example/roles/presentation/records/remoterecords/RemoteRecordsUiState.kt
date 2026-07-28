package com.example.roles.presentation.records.remoterecords

import com.example.roles.domain.model.RegisterPerson

data class RemoteRecordsUiState(
    val persons: List<RegisterPerson> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
