package com.bright.storage.model


import android.graphics.Bitmap
import android.net.Uri
import com.bright.storage.builder.StorageType

data class StorageFile(

    val uri: Uri,

    val name: String,

    val size: Long,

    val mimeType: String,

    val type: StorageType,
    val duration:Long? = null,
    val width: Int? = null,

    val height: Int? = null,

    val lastModified: Long? = null,
    val artist: String? = null,

    val album: String? = null,

    val genre: String? = null,

    val year: String? = null,

    val bitrate: Int? = null,

    val albumArt: Bitmap? = null,


    )