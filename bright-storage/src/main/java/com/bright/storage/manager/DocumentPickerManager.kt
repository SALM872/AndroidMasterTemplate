package com.bright.storage.manager

import com.bright.storage.callback.StorageCallback
import com.bright.storage.engine.DocumentPickerEngine

internal object DocumentPickerManager {

    fun pickDocument(
        callback: StorageCallback
    ) {
        DocumentPickerEngine.pickDocument(callback)
    }

    fun pickDocuments(
        callback: StorageCallback
    ) {
        DocumentPickerEngine.pickDocuments(callback)
    }

}