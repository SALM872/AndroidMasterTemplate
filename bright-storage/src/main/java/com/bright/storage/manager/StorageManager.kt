package com.bright.storage.manager

import androidx.activity.ComponentActivity
import com.bright.storage.builder.StorageConfig
import com.bright.storage.registry.LauncherRegistry

internal object StorageManager {

    private lateinit var activity: ComponentActivity

    private lateinit var config: StorageConfig

    fun initialize(
        activity: ComponentActivity,
        config: StorageConfig
    ) {

        this.activity = activity
        this.config = config
        LauncherRegistry.register(activity)

    }

    fun getactivity(): ComponentActivity {

        return activity

    }

    fun getconfig(): StorageConfig {

        return config

    }

    fun isInitialized(): Boolean {

        return ::activity.isInitialized

    }

}