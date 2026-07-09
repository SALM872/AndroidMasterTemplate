package com.bright.auth.google

import androidx.credentials.exceptions.GetCredentialCancellationException
import androidx.credentials.exceptions.GetCredentialException
import androidx.credentials.exceptions.NoCredentialException
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException
import com.bright.auth.exceptions.AuthException
import com.bright.auth.model.AuthResult

internal object GoogleAuthExceptionMapper {

    fun map(
        exception: GetCredentialException
    ): AuthResult {

        return when (exception) {

            is GetCredentialCancellationException -> {

                AuthResult.Cancelled

            }

            is NoCredentialException -> {

                AuthResult.Error(

                    AuthException.NoCredentials

                )

            }

            is GetCredentialProviderConfigurationException -> {

                AuthResult.Error(

                    AuthException.ConfigurationError

                )

            }

            else -> {

                AuthResult.Error(

                    AuthException.Unknown(exception)

                )

            }

        }

    }

}