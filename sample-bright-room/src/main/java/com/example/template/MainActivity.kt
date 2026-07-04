package com.example.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bright.room.builder.BrightRoom
import com.bright.room.builder.BrightRoomConfig
import com.example.template.data.database.AppDatabase
import com.example.template.ui.screens.MainScreen
import com.example.template.ui.theme.TestLibraryTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BrightRoom.initialize<AppDatabase>(
            context = applicationContext,
            config = BrightRoomConfig(
                databaseName = "sample.db",
                enableLogs = true,
                exportSchema = false
            )
        )

        enableEdgeToEdge()

        setContent {
            TestLibraryTheme {
                MainScreen()
            }
        }
    }
}