package com.bright.auth.google

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.bright.auth.callback.AuthCallback
import com.bright.auth.core.AuthEngine
import com.bright.auth.exceptions.AuthException
import com.bright.auth.manager.AuthManager
import com.bright.auth.model.AuthResult
import com.bright.auth.session.AuthSessionManager
import kotlinx.coroutines.launch

internal class GoogleAuthEngine : AuthEngine {



    override fun signIn(
        callback: AuthCallback
    ) {

        val activity = AuthManager.requireActivity()

        val client = GoogleAuthClient(activity)

        activity.lifecycleScope.launch {

            val result = client.signIn()

            if (result.isSuccess) {

                val authResult =
                    GoogleAuthParser.parse(
                        result.getOrThrow()
                    )

                if (authResult is AuthResult.Success) {

                    AuthSessionManager.saveUser(
                        authResult.user
                    )

                }

                callback.onResult(authResult)

            } else {

                val throwable = result.exceptionOrNull()

                Log.e(
                    "BrightAuth",
                    throwable?.stackTraceToString() ?: "Unknown error"
                )

                val exception = result.exceptionOrNull()

                if (exception is androidx.credentials.exceptions.GetCredentialException) {

                    callback.onResult(

                        GoogleAuthExceptionMapper.map(exception)

                    )

                } else {

                    callback.onResult(

                        AuthResult.Error(

                            AuthException.Unknown(exception)

                        )

                    )

                }

            }

        }

    }

    override fun signOut() {

        val activity = AuthManager.requireActivity()

        val client = GoogleAuthClient(activity)

        activity.lifecycleScope.launch {

            client.signOut()

            AuthSessionManager.clear()

        }

    }

    override fun isSignedIn(): Boolean {

        return AuthSessionManager.isLoggedIn()

    }

}