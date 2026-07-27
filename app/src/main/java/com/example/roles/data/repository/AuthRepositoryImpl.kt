package com.example.roles.data.repository

import com.example.roles.domain.model.Role
import com.example.roles.domain.model.UserSession
import com.example.roles.domain.repository.AuthRepository

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(username: String, password: String): Result<UserSession> {
        return when {

            username == "operador" && password == "1234" -> {

                Result.success(
                    UserSession(
                        token = "jwt_operador_fake",
                        role = Role.OPERATOR
                    )
                )

            }

            username == "supervisor" && password == "1234" -> {

                Result.success(
                    UserSession(
                        token = "jwt_supervisor_fake",
                        role = Role.SUPERVISOR
                    )
                )

            }

            else -> {

                Result.failure(
                    Exception("Usuario o contraseña incorrectos.")
                )

            }
        }
    }

}