package com.example.roles.di

import android.content.Context
import androidx.room.Room
import com.example.roles.data.local.AppDatabase
import com.example.roles.data.local.dao.RegisterPersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "roles_database"
        ).build()

    @Provides
    fun provideRegisterPersonDao(
        database: AppDatabase
    ): RegisterPersonDao =
        database.registerPersonDao()
}