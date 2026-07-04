package com.bright.demo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bright.permission.api.BrightPermission
import com.bright.permission.model.PermissionType

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BrightPermission.initialize(this)

        setContent {
            MaterialTheme {
                PermissionDemo()
            }
        }
    }

    @Composable
    private fun PermissionDemo() {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {

                    BrightPermission.request(
                        permission = PermissionType.CAMERA
                    ) { result ->

                        Toast.makeText(
                            this@MainActivity,
                            result.toString(),
                            Toast.LENGTH_SHORT
                        ).show()

                        if (result.isPermanentlyDenied) {

                            BrightPermission.openSettings(this@MainActivity)

                        }

                    }

                }
            ) {

                Text("Request Camera Permission")

            }

        }

    }
}