package com.bright.auth.callback



import com.bright.auth.model.AuthResult


fun interface AuthCallback {

    fun onResult(
        result: AuthResult
    )

}