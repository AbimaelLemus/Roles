package com.example.roles.domain.usecase

data class UseCases(
    val insertRegisterPerson: InsertRegisterPersonUseCase,
    val getRegisterPersons: GetRegisterPersonsUseCase,
    val deleteRegisterPerson: DeleteRegisterPersonUseCase
)