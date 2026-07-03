package com.bright.room.database

import androidx.room.RoomDatabase

object DatabaseProvider {

    private lateinit var roomDatabase: RoomDatabase

    fun initialize(database: RoomDatabase) {
        roomDatabase = database
    }

    fun getDatabase(): RoomDatabase {
        check(::roomDatabase.isInitialized) {
            "BrightRoom is not initialized. Call BrightRoom.initialize(...) first."
        }
        return roomDatabase
    }

    fun isInitialized(): Boolean = ::roomDatabase.isInitialized
}