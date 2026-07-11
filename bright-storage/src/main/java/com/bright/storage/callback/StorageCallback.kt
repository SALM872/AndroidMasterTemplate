package com.bright.storage.callback

import com.bright.storage.model.StorageResult

fun interface StorageCallback {

    fun onResult(
        result: StorageResult
    )

}