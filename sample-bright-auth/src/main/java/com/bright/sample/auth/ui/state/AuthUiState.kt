package com.bright.sample.auth.ui.state

data class AuthUiState(

    val initialized: Boolean = false,

    val signedIn: Boolean = false,

    val status: String = "Not Initialized",

    val name: String = "-",

    val email: String = "-",

    val provider: String = "-",

    val idToken: String = "-"

)