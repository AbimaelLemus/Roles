package com.example.roles.domain.repository

import com.example.roles.domain.model.RegisterPerson

interface RemoteRecordRepository {
    suspend fun getPersons(): List<RegisterPerson>
    suspend fun createRecord(person: RegisterPerson) : RegisterPerson
}