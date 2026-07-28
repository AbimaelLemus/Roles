package com.example.roles.domain.repository

import com.example.roles.domain.model.RegisterPerson
import kotlinx.coroutines.flow.Flow

interface RegisterPersonRepository {

    suspend fun insertPerson(person: RegisterPerson)

    fun getAll(): Flow<List<RegisterPerson>>

    suspend fun deletePerson(person: RegisterPerson)
}