package com.example.template.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.template.data.dao.UserDao
import com.example.template.data.entity.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}