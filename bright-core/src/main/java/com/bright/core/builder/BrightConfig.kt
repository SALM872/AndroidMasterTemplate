package com.bright.core.builder

data class BrightConfig(
    val enableLogs: Boolean = true,
    val libraryName: String = "BrightSDK",
    val webClientId: String =""
)