package com.example.roles.domain.usecase

import com.example.roles.domain.model.UserSession
import com.example.roles.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(
        username: String,
        password: String
    ): Result<UserSession> =
        authRepository.login(username, password)

}