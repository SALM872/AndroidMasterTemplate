package com.bright.room.builder

import androidx.room.migration.Migration

data class BrightRoomConfig(

    val databaseName: String,

    val enableLogs: Boolean = true,

    val exportSchema: Boolean = false,

    val fallbackToDestructiveMigration: Boolean = false,

    val migrations: List<Migration> = emptyList()
)