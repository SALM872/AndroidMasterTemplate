package com.bright.storage.engine

import com.bright.storage.callback.StorageCallback
import com.bright.storage.launcher.CameraImageLauncher
import com.bright.storage.launcher.CameraVideoLauncher

internal object CameraEngine {

    fun captureImage(
        callback: StorageCallback
    ) {

        CameraImageLauncher.launch(
            callback = callback
        )

    }

    fun captureVideo(
        callback: StorageCallback
    ) {

        CameraVideoLauncher.launch(
            callback = callback
        )

    }

}