package com.bright.storage.engine

import com.bright.storage.callback.StorageCallback
import com.bright.storage.launcher.AudioPickerLauncher
import com.bright.storage.launcher.MultipleAudioPickerLauncher

internal object AudioPickerEngine {

    fun pickAudio(
        callback: StorageCallback
    ) {

        AudioPickerLauncher.launch(
            callback = callback
        )

    }

    fun pickAudios(
        callback: StorageCallback
    ) {

        MultipleAudioPickerLauncher.launch(
            callback = callback
        )

    }

}