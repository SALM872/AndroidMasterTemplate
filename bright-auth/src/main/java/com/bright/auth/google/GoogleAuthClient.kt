package com.bright.auth.google


import androidx.credentials.GetCredentialResponse
import androidx.activity.ComponentActivity
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.ClearCredentialException
import androidx.credentials.exceptions.GetCredentialException
import com.bright.core.builder.BrightInitializer
import com.google.android.libraries.identity.googleid.GetGoogleIdOption

internal class GoogleAuthClient(

    private val activity: ComponentActivity

) {

    private val credentialManager =
        CredentialManager.create(activity)

    private fun createRequest(): GetCredentialRequest {

        val config = BrightInitializer.getConfig()

        val googleIdOption =
            GetGoogleIdOption.Builder()
                .setServerClientId(config.webClientId)
                .setFilterByAuthorizedAccounts(false)
                .build()

        return GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

    }
    suspend fun signIn(): Result<GetCredentialResponse> {

        return try {

            val response = credentialManager.getCredential(
                context = activity,
                request = createRequest()
            )

            Result.success(response)

        } catch (e: GetCredentialException) {

            Result.failure(e)

        }

    }
    suspend fun signOut(): Result<Unit> {

        return try {

            credentialManager.clearCredentialState(

                ClearCredentialStateRequest()

            )

            Result.success(Unit)

        } catch (e: ClearCredentialException) {

            Result.failure(e)

        }

    }
}