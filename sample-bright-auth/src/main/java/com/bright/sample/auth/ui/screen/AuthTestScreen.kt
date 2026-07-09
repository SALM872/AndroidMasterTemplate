package com.bright.sample.auth.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bright.sample.auth.ui.component.ResultCard
import com.bright.sample.auth.ui.state.AuthUiState
import androidx.activity.ComponentActivity
import com.bright.auth.api.BrightAuth
import com.bright.auth.builder.BrightAuthConfig
import com.bright.auth.builder.GoogleAuthConfig
import com.bright.auth.model.AuthResult

@Composable
fun AuthTestScreen(
    activity:ComponentActivity
) {

    var state by remember {
        mutableStateOf(AuthUiState())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text("Bright Auth Sample")

        Button(
            onClick = {

                BrightAuth.initialize(

                    activity = activity,

                    config = BrightAuthConfig(

                        enableLogs = true,

                        google = GoogleAuthConfig(

                            webClientId =
                                "9612807790-l04bmq6nn7k7bi5gm41ttt25n5vvp104.apps.googleusercontent.com"

                        )

                    )

                )

                state = state.copy(

                    initialized = BrightAuth.isInitialized(),

                    status = "BrightAuth Initialized"

                )

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Initialize")
        }

        Button(
            onClick = {

                BrightAuth.signIn { result ->

                    when (result) {

                        is AuthResult.Success -> {

                            state = state.copy(

                                signedIn = true,

                                status = "Login Success",

                                name = result.user.name,

                                email = result.user.email,

                                provider = result.user.provider.name,

                                idToken = result.user.idToken ?: "-"

                            )

                        }

                        is AuthResult.Cancelled -> {

                            state = state.copy(

                                signedIn = false,

                                status = "User Cancelled Login"

                            )

                        }

                        is AuthResult.Error -> {

                            state = state.copy(

                                signedIn = false,

                                status = result.exception.message

                            )

                        }

                    }

                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Google Sign In")
        }

        Button(
            onClick = {

                BrightAuth.signOut()

                state = state.copy(

                    signedIn = false,

                    status = "Signed Out",

                    name = "",

                    email = "",

                    provider = "",

                    idToken = ""

                )

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Google Sign Out")
        }

        Button(
            onClick = {

                state = state.copy(
                    signedIn = BrightAuth.isSignedIn()
                )

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Is Signed In")
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        ResultCard(
            state = state
        )

    }

}