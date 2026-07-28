package com.example.roles.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roles.data.local.dao.RegisterPersonDao
import com.example.roles.data.local.entity.RegisterPersonEntity

@Database(entities = [RegisterPersonEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun registerPersonDao(): RegisterPersonDao
}
