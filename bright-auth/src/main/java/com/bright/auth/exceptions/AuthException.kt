package com.bright.auth.exceptions

sealed class AuthException(

    override val message: String

) : Exception(message) {

    data object UserCancelled : AuthException(
        "User cancelled authentication."
    )

    data object NoCredentials : AuthException(
        "No credentials available."
    )

    data object NetworkError : AuthException(
        "Network error."
    )

    data object ConfigurationError : AuthException(
        "Authentication configuration is invalid."
    )

    data object PlayServicesUnavailable : AuthException(
        "Google Play Services unavailable."
    )

    data class Unknown(

        val throwable: Throwable? = null

    ) : AuthException(

        throwable?.message ?: "Unknown authentication error."

    )

}