package com.example.roles.di

import com.example.roles.data.remote.AuthApi
import com.example.roles.data.remote.RemoteApi
import com.example.roles.data.remote.api.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi =
        RetrofitClient.authApi
    @Provides
    @Singleton
    fun providePersonApi(): RemoteApi =
        RetrofitClient.remoteApi
}