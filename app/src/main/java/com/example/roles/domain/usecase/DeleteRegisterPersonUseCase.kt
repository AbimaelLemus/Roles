package com.example.roles.domain.usecase

import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.repository.RegisterPersonRepository

class DeleteRegisterPersonUseCase(
    private val repository: RegisterPersonRepository
) {
    suspend operator fun invoke(
        registerPerson: RegisterPerson
    ) {
        repository.deletePerson(registerPerson)
    }
}