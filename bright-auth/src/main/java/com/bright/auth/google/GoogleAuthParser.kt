package com.bright.auth.google

import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialResponse
import com.bright.auth.exceptions.AuthException
import com.bright.auth.model.AuthProvider
import com.bright.auth.model.AuthResult
import com.bright.auth.model.AuthUser
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException

internal object GoogleAuthParser {

    fun parse(
        response: GetCredentialResponse
    ): AuthResult {

        val credential = response.credential

        if (
            credential is CustomCredential &&
            credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
        ) {

            return try {

                val googleCredential =
                    GoogleIdTokenCredential.createFrom(
                        credential.data
                    )

                AuthResult.Success(

                    user = AuthUser(

                        id = googleCredential.id,

                        name = googleCredential.displayName.orEmpty(),

                        email = googleCredential.id,

                        photoUrl = googleCredential.profilePictureUri?.toString(),

                        idToken = googleCredential.idToken,

                        provider = AuthProvider.GOOGLE

                    )

                )

            } catch (_: GoogleIdTokenParsingException) {

                AuthResult.Error(

                    AuthException.ConfigurationError

                )

            }

        }

        return AuthResult.Error(

            AuthException.Unknown()

        )

    }

}