package com.bright.storage.manager

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

internal object CameraManager {

    private var currentUri: Uri? = null

    fun createImageUri(
        context: Context
    ): Uri {

        val file = File(
            context.cacheDir,
            "IMG_${System.currentTimeMillis()}.jpg"
        )

        currentUri = FileProvider.getUriForFile(
            context,
            context.packageName + ".brightstorage.provider",
            file
        )

        return currentUri!!

    }

    fun createVideoUri(
        context: Context
    ): Uri {

        val file = File(
            context.cacheDir,
            "VID_${System.currentTimeMillis()}.mp4"
        )

        currentUri = FileProvider.getUriForFile(
            context,
            context.packageName + ".brightstorage.provider",
            file
        )

        return currentUri!!

    }

    fun currentUri(): Uri? {

        return currentUri

    }

}