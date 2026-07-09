package com.bright.auth.model

import com.bright.auth.exceptions.AuthException

sealed class AuthResult {

    data class Success(

        val user: AuthUser

    ) : AuthResult()

    data class Error(

        val exception: AuthException

    ) : AuthResult()

    data object Cancelled : AuthResult()

}