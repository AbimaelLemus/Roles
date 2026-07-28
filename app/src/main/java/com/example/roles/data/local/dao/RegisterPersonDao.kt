package com.example.roles.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roles.data.local.entity.RegisterPersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RegisterPersonDao {
    @Insert
    suspend fun insertPerson(person: RegisterPersonEntity)

    @Query("SELECT * FROM persons")
    fun getAllPersons(): Flow<List<RegisterPersonEntity>>

    @Delete
    suspend fun deletePerson(person: RegisterPersonEntity)
}