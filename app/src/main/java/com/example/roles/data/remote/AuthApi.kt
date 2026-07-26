package com.example.roles.data.remote

interface AuthApi {
    suspend fun login(request: LoginRequestDto): LoginResponseDto
}