package com.bright.storage.api

import androidx.activity.ComponentActivity
import com.bright.storage.builder.StorageConfig
import com.bright.storage.callback.StorageCallback
import com.bright.storage.engine.StorageEngine
import com.bright.storage.manager.StorageManager

object BrightStorage {

    fun initialize(
        activity: ComponentActivity,
        config: StorageConfig = StorageConfig()
    ) {

        StorageManager.initialize(
            activity = activity,
            config = config
        )

    }

    fun isInitialized(): Boolean {

        return StorageManager.isInitialized()

    }
    fun pickImage(
        callback: StorageCallback
    ) {

        StorageEngine.pickImage(
            callback = callback
        )

    }
    fun pickVideo(
        callback: StorageCallback
    ) {
        StorageEngine.pickVideo(callback)
    }

    fun pickImages(
        callback: StorageCallback
    ) {

        StorageEngine.pickImages(
            callback = callback
        )

    }
    fun pickVideos(
        callback: StorageCallback
    ) {
        StorageEngine.pickVideos(
            callback = callback
        )
    }
    fun pickDocument(
        callback: StorageCallback
    ) {

        StorageEngine.pickDocument(
            callback = callback
        )

    }

    fun pickDocuments(
        callback: StorageCallback
    ) {

        StorageEngine.pickDocuments(
            callback = callback
        )

    }
    fun pickAudio(
        callback: StorageCallback
    ) {

        StorageEngine.pickAudio(
            callback = callback
        )

    }

    fun pickAudios(
        callback: StorageCallback
    ) {

        StorageEngine.pickAudios(
            callback = callback
        )

    }
    fun captureImage(
        callback: StorageCallback
    ) {

        StorageEngine.captureImage(
            callback = callback
        )

    }

    fun captureVideo(
        callback: StorageCallback
    ) {

        StorageEngine.captureVideo(
            callback = callback
        )

    }


}