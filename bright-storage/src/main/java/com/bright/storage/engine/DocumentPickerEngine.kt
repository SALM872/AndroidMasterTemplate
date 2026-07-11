package com.bright.storage.engine

import com.bright.storage.callback.StorageCallback
import com.bright.storage.launcher.DocumentPickerLauncher
import com.bright.storage.launcher.MultipleDocumentPickerLauncher

internal object DocumentPickerEngine {

    fun pickDocument(
        callback: StorageCallback
    ) {
        DocumentPickerLauncher.launch(callback)
    }

    fun pickDocuments(
        callback: StorageCallback
    ) {
        MultipleDocumentPickerLauncher.launch(callback)
    }

}