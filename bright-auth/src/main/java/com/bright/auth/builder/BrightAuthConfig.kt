package com.bright.auth.builder

data class BrightAuthConfig(

    val enableLogs: Boolean = false,

    val google: GoogleAuthConfig,

    val facebook: FacebookAuthConfig? = null

)