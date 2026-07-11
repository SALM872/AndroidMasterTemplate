package com.bright.sample.storage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bright.sample.storage.ui.StorageTestScreen
import com.bright.sample.storage.ui.theme.AndroidMasterTemplateTheme

import com.bright.storage.api.BrightStorage
import com.bright.storage.builder.StorageConfig

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BrightStorage.initialize(
            activity = this,
            config = StorageConfig(
                enableLogs = true
            )
        )

        setContent {
            AndroidMasterTemplateTheme {
                StorageTestScreen()
            }
        }
    }
}