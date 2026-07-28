package com.example.roles.domain.usecase

import com.example.roles.domain.repository.RegisterPersonRepository

class GetRegisterPersonsUseCase(
    private val repository: RegisterPersonRepository
) {

    operator fun invoke() =
        repository.getAll()

}