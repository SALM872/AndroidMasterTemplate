package com.bright.auth.manager

import androidx.activity.ComponentActivity
import com.bright.auth.builder.BrightAuthConfig
import com.bright.auth.builder.BrightAuthInitializer
import com.bright.auth.callback.AuthCallback
import com.bright.auth.core.AuthEngine
import com.bright.auth.exceptions.AuthException
import com.bright.auth.google.GoogleAuthEngine
import com.bright.auth.model.AuthResult
import com.bright.auth.model.AuthUser
import com.bright.auth.session.AuthSessionManager

internal object AuthManager {

    private var activity: ComponentActivity? = null

    private var engine: AuthEngine? = null

    fun initialize(
        activity: ComponentActivity,
        config: BrightAuthConfig
    ) {

        this.activity = activity

        BrightAuthInitializer.initialize(config)
        setEngine(
           com.bright.auth.google.GoogleAuthEngine()
        )

    }

    fun setEngine(
        engine: AuthEngine
    ) {

        this.engine = engine

    }

    fun signIn(
        callback: AuthCallback
    ) {

        if (engine == null) {

            callback.onResult(

                AuthResult.Error(

                    AuthException.ConfigurationError

                )

            )

            return

        }

        engine?.signIn(callback)

    }

    fun signOut() {

        if (engine == null) {

            AuthSessionManager.clear()

            return

        }

        engine?.signOut()

    }

    fun isSignedIn(): Boolean {

        return AuthSessionManager.isLoggedIn()

    }

    fun currentUser(): AuthUser? {

        return AuthSessionManager.getUser()

    }






    fun requireActivity(): ComponentActivity {

        return activity
            ?: error("BrightAuth.initialize() must be called first.")

    }
    fun isInitialized(): Boolean {
        return BrightAuthInitializer.isInitialized()
    }

}