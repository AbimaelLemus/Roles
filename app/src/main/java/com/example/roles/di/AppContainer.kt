package com.example.roles.di

import android.content.Context
import androidx.room.Room
import com.example.roles.data.local.AppDatabase
import com.example.roles.data.remote.api.RetrofitClient
import com.example.roles.data.repository.RegisterPersonRepositoryImpl
import com.example.roles.data.repository.RemoteRecordRepositoryImpl
import com.example.roles.domain.usecase.DeleteRegisterPersonUseCase
import com.example.roles.domain.usecase.GetRegisterPersonsUseCase
import com.example.roles.domain.usecase.GetRemotePersonsUseCase
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
    * REMOTE REPOSITORY
    */

    private val remoteRecordRepository =
        RemoteRecordRepositoryImpl(
            RetrofitClient.remoteApi
        )

    /*
     * USE CASES
     */

    val useCases = UseCases(

        insertRegisterPerson =
        InsertRegisterPersonUseCase(
            registerPersonRepository,
            remoteRecordRepository
        ),

        getRegisterPersons =
        GetRegisterPersonsUseCase(registerPersonRepository),

        deleteRegisterPerson =
        DeleteRegisterPersonUseCase(registerPersonRepository),

        getRemotePersons =
        GetRemotePersonsUseCase(remoteRecordRepository)

    )

}