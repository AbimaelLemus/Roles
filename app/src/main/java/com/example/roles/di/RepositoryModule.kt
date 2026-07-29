package com.example.roles.di

import com.example.roles.data.repository.AuthRepositoryImpl
import com.example.roles.data.repository.RemoteRecordRepositoryImpl
import com.example.roles.domain.repository.AuthRepository
import com.example.roles.domain.repository.RemoteRecordRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindRemoteRecordRepository(
        repository: RemoteRecordRepositoryImpl
    ): RemoteRecordRepository
}