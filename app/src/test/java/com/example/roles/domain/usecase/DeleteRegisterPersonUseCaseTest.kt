package com.example.roles.domain.usecase

import com.example.roles.domain.model.RegisterPerson
import com.example.roles.domain.repository.RegisterPersonRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class DeleteRegisterPersonUseCaseTest {

    @Test
    fun `should delete person from repository`() = runTest {

        //Arrange
        val repository = mockk<RegisterPersonRepository>()
        val useCase = DeleteRegisterPersonUseCase(repository)

        val person = RegisterPerson(
            id = 1,
            name = "John Doe",
            age = 30,
            educationLevel = "Ing",
        )

        coEvery {
            repository.deletePerson(person)
        } returns Unit

        //Act
        useCase(person)

        //Assert
        coVerify(exactly = 1) {
            repository.deletePerson(person)
        }
    }

}