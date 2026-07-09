package com.bright.sample.auth.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bright.sample.auth.ui.state.AuthUiState

@Composable
fun ResultCard(

    state: AuthUiState

) {

    Card(

        modifier = Modifier.fillMaxWidth()

    ) {

        Column(

            modifier = Modifier.padding(16.dp)

        ) {

            Text("Status : ${state.status}")

            Text("Initialized : ${state.initialized}")

            Text("Signed In : ${state.signedIn}")

            Text("")

            Text("Name : ${state.name}")

            Text("Email : ${state.email}")

            Text("Provider : ${state.provider}")

            Text("")

            Text("Id Token")

            Text(state.idToken)

        }

    }

}