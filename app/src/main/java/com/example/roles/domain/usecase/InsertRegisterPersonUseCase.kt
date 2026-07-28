package com.example.roles.domain.usecase

import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.repository.RegisterPersonRepository

class InsertRegisterPersonUseCase(
    private val repository: RegisterPersonRepository
) {
    suspend operator fun invoke(person: RegisterPerson) {
        repository.insertPerson(person)
    }
}