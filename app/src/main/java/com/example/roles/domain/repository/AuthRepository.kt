package com.example.roles.domain.repository

import com.example.roles.domain.model.UserSession

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<UserSession>
}