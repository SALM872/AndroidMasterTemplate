package com.bright.auth.builder

import com.bright.core.builder.BrightConfig
import com.bright.core.builder.BrightInitializer

internal object BrightAuthInitializer {

    fun initialize(
        config: BrightAuthConfig
    ) {

        BrightInitializer.initialize(

            BrightConfig(

                libraryName = "BrightAuth",

                enableLogs = config.enableLogs,

                webClientId = config.google.webClientId

            )

        )

    }
    fun isInitialized(): Boolean {

        return BrightInitializer.isInitialized()

    }

}