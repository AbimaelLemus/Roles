package com.example.roles.domain.model

data class RegisterPerson(
    val id: Long = 0,
    val name: String,
    val age: Int,
    val educationLevel: String
)
