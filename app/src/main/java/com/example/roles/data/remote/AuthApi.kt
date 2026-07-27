package com.example.roles.data.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login")
    suspend fun login(
        @Body request: LoginRequestDto
    ): LoginResponseDto
}