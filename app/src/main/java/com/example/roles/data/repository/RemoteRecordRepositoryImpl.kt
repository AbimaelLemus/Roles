package com.example.roles.data.repository

import com.example.roles.data.mapper.toDomain
import com.example.roles.data.remote.RemoteApi
import com.example.roles.data.remote.RemoteRecordDto
import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.repository.RemoteRecordRepository

class RemoteRecordRepositoryImpl(
    private val api: RemoteApi
) : RemoteRecordRepository {
    override suspend fun getPersons(): List<RegisterPerson> {
        return api
            .getPersons()
            .map {
                it.toDomain()
            }
    }

    override suspend fun createRecord(
        person: RegisterPerson
    ): RegisterPerson {
        return  api.createPerson(
            RemoteRecordDto(
                id = person.id,
                name = person.name,
                age = person.age,
                educationLevel = person.educationLevel
            )
        ).toDomain()
    }
}