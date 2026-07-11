package com.bright.storage.launcher

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bright.storage.callback.StorageCallback
import com.bright.storage.model.StorageResult
import com.bright.util.StorageFileResolver

internal object AudioPickerLauncher {

    private lateinit var launcher: ActivityResultLauncher<Array<String>>

    private var callback: StorageCallback? = null

    fun register(
        activity: ComponentActivity
    ) {

        launcher = activity.registerForActivityResult(
            ActivityResultContracts.OpenDocument()
        ) { uri: Uri? ->

            if (uri == null) {

                callback?.onResult(
                    StorageResult.Cancelled
                )

                return@registerForActivityResult
            }

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

        launcher.launch(
            arrayOf("audio/*")
        )

    }

}