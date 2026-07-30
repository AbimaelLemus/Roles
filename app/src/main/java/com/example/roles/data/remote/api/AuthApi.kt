package com.example.roles.data.remote.api

import com.example.roles.data.remote.LoginRequestDto
import com.example.roles.data.remote.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login")
    suspend fun login(
        @Body request: LoginRequestDto
    ): LoginResponseDto
}