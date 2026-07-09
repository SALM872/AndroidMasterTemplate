package com.bright.core.builder

import com.bright.core.logger.BrightLogger

object BrightInitializer {

    private var initialized = false
    private lateinit var config: BrightConfig

    fun initialize(config: BrightConfig) {

        if (initialized) return

        this.config = config
        initialized = true

        if (config.enableLogs) {
            BrightLogger.d("${config.libraryName} Initialized")
        }
    }

    fun getConfig() = config

    fun isInitialized() = initialized
}