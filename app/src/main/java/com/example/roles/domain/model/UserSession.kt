package com.example.roles.domain.model

data class UserSession(
    val token: String,
    val role: Role,
    val username: String
)
