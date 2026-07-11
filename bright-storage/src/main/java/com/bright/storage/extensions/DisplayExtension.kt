package com.bright.storage.extensions

import com.bright.storage.builder.StorageType
import com.bright.storage.model.StorageFile

val StorageFile.displayIcon: String
    get() = when (type) {
        StorageType.IMAGE -> "🖼"
        StorageType.VIDEO -> "🎥"
        StorageType.DOCUMENT -> "📄"
        StorageType.AUDIO -> "🎵"
        StorageType.UNKNOWN -> "📦"
    }

val StorageFile.displayName: String
    get() = when (type) {
        StorageType.IMAGE -> "Image"
        StorageType.VIDEO -> "Video"
        StorageType.DOCUMENT -> "Document"
        StorageType.AUDIO -> "Audio"
        StorageType.UNKNOWN -> "File"
    }