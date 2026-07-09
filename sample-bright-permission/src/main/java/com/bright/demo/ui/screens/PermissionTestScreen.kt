package com.bright.demo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bright.permission.api.BrightPermission
import com.bright.permission.model.PermissionState
import com.bright.permission.model.PermissionType

@Composable
fun PermissionTestScreen() {

    val context = LocalContext.current

    var resultText by remember {
        mutableStateOf("Press any button to test BrightPermission.")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Bright Permission Tester",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("Library Status")

                Spacer(modifier = Modifier.height(8.dp))

                Text("Version : v1.0.0")

                Text("Status : Ready ✅")

            }

        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                BrightPermission.request(
                    permission = PermissionType.CAMERA
                ) { result ->

                    resultText = when (result.state) {

                        PermissionState.GRANTED ->
                            "✅ Camera Permission Granted"

                        PermissionState.DENIED ->
                            "❌ Camera Permission Denied"

                        PermissionState.PERMANENTLY_DENIED ->
                            "⚠ Camera Permanently Denied"
                    }

                }

            }
        ) {

            Text("Camera Permission")

        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                BrightPermission.request(
                    permission = PermissionType.MICROPHONE
                ) { result ->

                    resultText = when (result.state) {

                        PermissionState.GRANTED ->
                            "✅ Microphone Permission Granted"

                        PermissionState.DENIED ->
                            "❌ Microphone Permission Denied"

                        PermissionState.PERMANENTLY_DENIED ->
                            "⚠ Microphone Permanently Denied"
                    }

                }

            }
        ) {

            Text("Microphone Permission")

        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                BrightPermission.request(
                    permission = PermissionType.STORAGE
                ) { result ->

                    resultText = when (result.state) {

                        PermissionState.GRANTED ->
                            "✅ Storage Permission Granted"

                        PermissionState.DENIED ->
                            "❌ Storage Permission Denied"

                        PermissionState.PERMANENTLY_DENIED ->
                            "⚠ Storage Permanently Denied"
                    }

                }

            }
        ) {

            Text("Storage Permission")

        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                BrightPermission.request(

                    PermissionType.CAMERA,
                    PermissionType.MICROPHONE,
                    PermissionType.STORAGE

                ) { results ->

                    val granted =
                        results.results.count {
                            it.value.state == PermissionState.GRANTED
                        }

                    resultText =
                        "All Permission Result\n\nGranted : $granted / ${results.results.size}"

                }

            }
        ) {

            Text("Request All Permissions")

        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

                BrightPermission.openSettings(context)

            }
        ) {

            Text("Open App Settings")

        }

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = resultText,
                modifier = Modifier.padding(16.dp)
            )

        }

    }

}