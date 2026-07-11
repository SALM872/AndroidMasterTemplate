package com.bright.storage.model

sealed class StorageResult {

    data class Success(

        val files: List<StorageFile>

    ) : StorageResult()

    data class Error(

        val exception: StorageException

    ) : StorageResult()

    data object Cancelled : StorageResult()

}