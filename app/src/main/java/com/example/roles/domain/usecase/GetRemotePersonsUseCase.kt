package com.example.roles.domain.usecase

import com.example.roles.domain.repository.RemoteRecordRepository
import javax.inject.Inject

class GetRemotePersonsUseCase @Inject constructor(
    private val repository: RemoteRecordRepository
) {
    suspend operator fun invoke() =
        repository.getPersons()
}