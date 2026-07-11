package com.bright.storage.manager

import com.bright.storage.callback.StorageCallback
import com.bright.storage.engine.AudioPickerEngine

internal object AudioPickerManager {

    fun pickAudio(
        callback: StorageCallback
    ) {

        AudioPickerEngine.pickAudio(
            callback = callback
        )

    }

    fun pickAudios(
        callback: StorageCallback
    ) {

        AudioPickerEngine.pickAudios(
            callback = callback
        )

    }

}