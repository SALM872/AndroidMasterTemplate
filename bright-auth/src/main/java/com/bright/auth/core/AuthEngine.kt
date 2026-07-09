package com.bright.auth.core

import com.bright.auth.callback.AuthCallback

internal interface AuthEngine {

    fun signIn(
        callback: AuthCallback
    )

    fun signOut()

    fun isSignedIn(): Boolean

}