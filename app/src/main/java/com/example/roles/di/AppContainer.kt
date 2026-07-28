package com.example.roles.di

import android.content.Context
import androidx.room.Room
import com.example.roles.data.local.AppDatabase
import com.example.roles.data.repository.RegisterPersonRepositoryImpl
import com.example.roles.domain.usecase.DeleteRegisterPersonUseCase
import com.example.roles.domain.usecase.GetRegisterPersonsUseCase
import com.example.roles.domain.usecase.InsertRegisterPersonUseCase
import com.example.roles.domain.usecase.UseCases

class AppContainer(
    context: Context
) {

    /*
     * ROOM
     */

    private val database =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "roles_database"
        ).build()

    /*
     * DAO
     */

    private val registerPersonDao =
        database.registerPersonDao()

    /*
     * REPOSITORY
     */

    private val registerPersonRepository =
        RegisterPersonRepositoryImpl(
            registerPersonDao
        )

    /*
     * USE CASES
     */

    val useCases = UseCases(

        insertRegisterPerson =
        InsertRegisterPersonUseCase(registerPersonRepository),

        getRegisterPersons =
        GetRegisterPersonsUseCase(registerPersonRepository),

        deleteRegisterPerson =
        DeleteRegisterPersonUseCase(registerPersonRepository)

    )

}