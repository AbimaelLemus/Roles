package com.example.roles.data.repository

import com.example.roles.data.remote.api.AuthApi
import com.example.roles.data.remote.LoginRequestDto
import com.example.roles.domain.model.UserSession
import com.example.roles.domain.repository.AuthRepository
import com.example.roles.utils.jwt.JwtUtils
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi
) : AuthRepository {

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
                    role = JwtUtils.getRole(response.token),
                    username = username
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}