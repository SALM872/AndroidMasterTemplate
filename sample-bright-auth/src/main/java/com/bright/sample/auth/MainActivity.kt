package com.bright.sample.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bright.sample.auth.ui.screen.AuthTestScreen
import com.bright.sample.auth.ui.theme.AndroidMasterTemplateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            AndroidMasterTemplateTheme {

                AuthTestScreen(
                    activity = this
                )

            }

        }

    }

}