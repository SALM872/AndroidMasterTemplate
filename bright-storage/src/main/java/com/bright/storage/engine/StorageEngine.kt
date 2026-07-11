package com.bright.storage.engine

import com.bright.storage.callback.StorageCallback
import com.bright.storage.launcher.ImagePickerLauncher
import com.bright.storage.launcher.MultipleImagePickerLauncher
import com.bright.storage.launcher.MultipleVideoPickerLauncher
import com.bright.storage.launcher.VideoPickerLauncher
import com.bright.storage.manager.AudioPickerManager
import com.bright.storage.manager.DocumentPickerManager

internal object StorageEngine {

    fun pickImage(
        callback: StorageCallback
    ) {

        ImagePickerLauncher.launch(
            callback = callback
        )

    }
    fun pickVideo(
        callback: StorageCallback
    ) {
        VideoPickerLauncher.launch(callback)
    }

    fun pickImages(
        callback: StorageCallback
    ) {

        MultipleImagePickerLauncher.launch(
            callback = callback
        )

    }
    fun pickVideos(
        callback: StorageCallback
    ) {
        MultipleVideoPickerLauncher.launch(
            callback = callback
        )
    }
    fun pickDocument(
        callback: StorageCallback
    ) {

        DocumentPickerManager.pickDocument(
            callback = callback
        )

    }

    fun pickDocuments(
        callback: StorageCallback
    ) {

        DocumentPickerManager.pickDocuments(
            callback = callback
        )

    }
    fun pickAudio(
        callback: StorageCallback
    ) {

        AudioPickerManager.pickAudio(
            callback = callback
        )

    }

    fun pickAudios(
        callback: StorageCallback
    ) {

        AudioPickerManager.pickAudios(
            callback = callback
        )

    }
    fun captureImage(
        callback: StorageCallback
    ) {

        CameraEngine.captureImage(
            callback = callback
        )

    }

    fun captureVideo(
        callback: StorageCallback
    ) {

        CameraEngine.captureVideo(
            callback = callback
        )

    }

}