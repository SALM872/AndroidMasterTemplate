package com.bright.auth.google

import androidx.activity.ComponentActivity

internal object GoogleAuthLauncher {

    fun createClient(
        activity: ComponentActivity
    ): GoogleAuthClient {

        return GoogleAuthClient(activity)

    }

}