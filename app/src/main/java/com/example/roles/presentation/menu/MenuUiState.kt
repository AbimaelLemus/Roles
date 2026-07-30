package com.example.roles.presentation.menu

import com.example.roles.domain.model.Role

data class MenuUiState(
    val role: Role? = null,
    val username: String = "",
)
