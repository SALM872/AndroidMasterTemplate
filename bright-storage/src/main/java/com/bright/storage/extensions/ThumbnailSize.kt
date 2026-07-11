package com.bright.storage.extensions

enum class ThumbnailSize(
    val width: Int,
    val height: Int
) {
    SMALL(96, 96),

    MEDIUM(256, 256),

    LARGE(512, 512),

    ORIGINAL(1024, 1024)
}