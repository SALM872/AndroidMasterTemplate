package com.bright.storage.launcher

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.bright.storage.callback.StorageCallback
import com.bright.storage.model.StorageResult
import com.bright.util.StorageFileResolver

internal object MultipleImagePickerLauncher {

    private lateinit var launcher: ActivityResultLauncher<PickVisualMediaRequest>

    private var callback: StorageCallback? = null

    fun register(
        activity: ComponentActivity
    ) {

        launcher = activity.registerForActivityResult(
            ActivityResultContracts.PickMultipleVisualMedia()
        ) { uris: List<Uri> ->

            if (uris.isEmpty()) {

                callback?.onResult(
                    StorageResult.Cancelled
                )

                return@registerForActivityResult
            }

            val files = uris.map {

                StorageFileResolver.resolve(
                    context = activity,
                    uri = it
                )

            }

            callback?.onResult(
                StorageResult.Success(
                    files = files
                )
            )

        }

    }

    fun launch(
        callback: StorageCallback
    ) {

        this.callback = callback

        launcher.launch(
            PickVisualMediaRequest(
                ActivityResultContracts.PickVisualMedia.ImageOnly
            )
        )

    }

}