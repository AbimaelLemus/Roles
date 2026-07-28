package com.example.roles.domain.usecase

import com.example.roles.domain.repository.RemoteRecordRepository

class GetRemotePersonsUseCase(
    private val repository: RemoteRecordRepository
) {
    suspend operator fun invoke() =
        repository.getPersons()
}