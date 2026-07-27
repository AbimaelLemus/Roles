package com.example.roles.data.repository

import com.example.roles.data.remote.LoginRequestDto
import com.example.roles.data.remote.api.RetrofitClient
import com.example.roles.domain.model.Role
import com.example.roles.domain.model.UserSession
import com.example.roles.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    private val api = RetrofitClient.authApi

    override suspend fun login(username: String, password: String): Result<UserSession> {
        return try {
            val response = api.login(
                LoginRequestDto(
                    username, password
                )
            )
            Result.success(
                UserSession(
                    token = response.token,
                    role = when (response.role) {
                        "SUPERVISOR" -> Role.SUPERVISOR
                        else -> Role.OPERATOR
                    }
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}