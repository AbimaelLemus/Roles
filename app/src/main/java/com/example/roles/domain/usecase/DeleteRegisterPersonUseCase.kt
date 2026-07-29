package com.example.roles.domain.usecase

import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.repository.RegisterPersonRepository
import javax.inject.Inject

class DeleteRegisterPersonUseCase @Inject constructor(
    private val repository: RegisterPersonRepository
) {
    suspend operator fun invoke(
        registerPerson: RegisterPerson
    ) {
        repository.deletePerson(registerPerson)
    }
}