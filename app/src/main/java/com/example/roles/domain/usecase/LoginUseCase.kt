package com.example.roles.domain.usecase

import com.example.roles.domain.model.UserSession
import com.example.roles.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(username: String, password: String): Result<UserSession> {
        return authRepository.login(username, password)
    }
}