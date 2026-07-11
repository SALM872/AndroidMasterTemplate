package com.bright.storage.launcher

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bright.storage.callback.StorageCallback
import com.bright.storage.manager.CameraManager
import com.bright.storage.model.StorageResult
import com.bright.util.StorageFileResolver

internal object CameraVideoLauncher {

    private lateinit var launcher: ActivityResultLauncher<Uri>

    private lateinit var activity: ComponentActivity

    private var callback: StorageCallback? = null

    fun register(
        activity: ComponentActivity
    ) {

        this.activity = activity

        launcher = activity.registerForActivityResult(
            ActivityResultContracts.CaptureVideo()
        ) { success ->

            if (!success) {

                callback?.onResult(
                    StorageResult.Cancelled
                )

                return@registerForActivityResult

            }

            val uri = CameraManager.currentUri()
                ?: return@registerForActivityResult

            val file = StorageFileResolver.resolve(
                context = activity,
                uri = uri
            )

            callback?.onResult(
                StorageResult.Success(
                    listOf(file)
                )
            )

        }

    }

    fun launch(
        callback: StorageCallback
    ) {

        this.callback = callback

        val uri = CameraManager.createVideoUri(
            activity
        )

        launcher.launch(uri)

    }

}