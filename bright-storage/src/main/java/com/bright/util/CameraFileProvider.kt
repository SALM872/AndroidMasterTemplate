package com.bright.util

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File

internal object CameraFileProvider {

    fun createImageUri(
        context: Context
    ): Uri {

        val imageFile = File(
            context.cacheDir,
            "IMG_${System.currentTimeMillis()}.jpg"
        )

        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.brightstorage.provider",
            imageFile
        )

    }

    fun createVideoUri(
        context: Context
    ): Uri {

        val videoFile = File(
            context.cacheDir,
            "VID_${System.currentTimeMillis()}.mp4"
        )

        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.brightstorage.provider",
            videoFile
        )

    }

}