package com.bright.auth.api

import androidx.activity.ComponentActivity
import com.bright.auth.builder.BrightAuthConfig
import com.bright.auth.callback.AuthCallback
import com.bright.auth.manager.AuthManager
import com.bright.auth.model.AuthUser

object BrightAuth {

    fun initialize(
        activity: ComponentActivity,
        config: BrightAuthConfig
    ) {

        AuthManager.initialize(
            activity = activity,
            config = config
        )

    }

    fun isInitialized(): Boolean {

        return AuthManager.isInitialized()

    }
    fun signIn(
        callback: AuthCallback
    ) {

        AuthManager.signIn(callback)

    }

    fun signOut() {

        AuthManager.signOut()

    }

    fun isSignedIn(): Boolean {

        return AuthManager.isSignedIn()

    }
    fun currentUser(): AuthUser? {

        return AuthManager.currentUser()

    }


}