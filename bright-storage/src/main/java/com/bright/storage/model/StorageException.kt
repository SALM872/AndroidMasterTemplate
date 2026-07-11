package com.bright.storage.model

sealed class StorageException(
    override val message: String
) : Exception(message) {

    data object PermissionDenied :
        StorageException("Permission denied.")

    data object NoFileSelected :
        StorageException("No file selected.")

    data object InvalidFile :
        StorageException("Invalid file.")

    data object Unknown :
        StorageException("Unknown error.")

}