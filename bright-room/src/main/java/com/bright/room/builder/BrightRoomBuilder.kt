package com.bright.room.builder

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object BrightRoomBuilder {

    inline fun <reified T : RoomDatabase> build(
        context: Context,
        config: BrightRoomConfig
    ): T {

        val builder = Room.databaseBuilder(
            context,
            T::class.java,
            config.databaseName
        )

        if (config.fallbackToDestructiveMigration) {
            builder.fallbackToDestructiveMigration(false)
        }
        if (config.migrations.isNotEmpty()) {
            builder.addMigrations(
                *config.migrations.toTypedArray()
            )
        }

        return builder.build()
    }
}