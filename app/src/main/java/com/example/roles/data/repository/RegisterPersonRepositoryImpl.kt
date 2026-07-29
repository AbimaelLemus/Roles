package com.example.roles.data.repository

import com.example.roles.data.local.dao.RegisterPersonDao
import com.example.roles.data.mapper.toDomain
import com.example.roles.data.mapper.toEntity
import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.repository.RegisterPersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RegisterPersonRepositoryImpl @Inject constructor(
    private val dao: RegisterPersonDao
) : RegisterPersonRepository {
    override suspend fun insertPerson(person: RegisterPerson) {
        dao.insertPerson(person.toEntity())
    }

    override fun getAll(): Flow<List<RegisterPerson>> {
        return dao
            .getAllPersons()
            .map { list ->
                list.map {
                    it.toDomain()
                }
            }
    }

    override suspend fun deletePerson(person: RegisterPerson) {
        dao.deletePerson(person.toEntity())
    }
}