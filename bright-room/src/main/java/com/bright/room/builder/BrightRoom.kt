package com.bright.room.builder

import android.content.Context
import androidx.room.RoomDatabase
import com.bright.room.database.DatabaseProvider

object BrightRoom {

    inline fun <reified T : RoomDatabase> initialize(
        context: Context,
        config: BrightRoomConfig
    ) {
        val database = BrightRoomBuilder.build<T>(
            context = context,
            config = config
        )

        DatabaseProvider.initialize(database)
    }
    inline fun <reified T : RoomDatabase> database(): T {
        return DatabaseProvider.getDatabase() as T
    }
}