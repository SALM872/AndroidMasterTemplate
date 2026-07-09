package com.bright.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bright.demo.ui.theme.TestLibraryTheme
import com.bright.permission.api.BrightPermission

import com.bright.demo.ui.screens.PermissionTestScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        BrightPermission.initialize(this)

        enableEdgeToEdge()

        setContent {

            TestLibraryTheme {

                PermissionTestScreen()

            }

        }
    }
}