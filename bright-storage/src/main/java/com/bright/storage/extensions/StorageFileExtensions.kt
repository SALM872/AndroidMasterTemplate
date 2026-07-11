package com.bright.storage.extensions

import com.bright.storage.model.StorageFile
import com.bright.storage.util.StorageFormatter

val StorageFile.readableSize: String
    get() = StorageFormatter.formatSize(size)

val StorageFile.extension: String
    get() = StorageFormatter.mimeToExtension(mimeType)

val StorageFile.isImage: Boolean
    get() = StorageFormatter.isImage(this)

val StorageFile.readableDuration: String
    get() = StorageFormatter.formatDuration(duration)
val StorageFile.resolution: String
    get() = StorageFormatter.formatResolution(
        width,
        height
    )

val StorageFile.modifiedDate: String
    get() = StorageFormatter.formatDate(
        lastModified
    )