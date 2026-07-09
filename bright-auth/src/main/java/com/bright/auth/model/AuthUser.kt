package com.bright.auth.model

data class AuthUser(

    val id: String,

    val name: String,

    val email: String,

    val photoUrl: String? = null,

    val idToken: String? = null,

    val provider: AuthProvider

)