package com.example.roles.domain.usecase

import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.repository.RegisterPersonRepository
import com.example.roles.domain.repository.RemoteRecordRepository
import javax.inject.Inject

class InsertRegisterPersonUseCase @Inject constructor(
    private val localRepository: RegisterPersonRepository,
    private val remoteRepository: RemoteRecordRepository
) {
    suspend operator fun invoke(person: RegisterPerson) {
        val remote = remoteRepository.createRecord(person)
        localRepository.insertPerson(remote)
    }
}