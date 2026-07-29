package com.example.roles.domain.usecase

import com.example.roles.domain.repository.RegisterPersonRepository
import javax.inject.Inject

class GetRegisterPersonsUseCase@Inject constructor (
    private val repository: RegisterPersonRepository
) {

    operator fun invoke() =
        repository.getAll()

}