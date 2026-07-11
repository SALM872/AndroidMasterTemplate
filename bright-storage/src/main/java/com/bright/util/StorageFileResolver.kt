package com.bright.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.provider.OpenableColumns
import com.bright.storage.builder.StorageType
import com.bright.storage.model.StorageFile

object StorageFileResolver {

    fun resolve(
        context: Context,
        uri: Uri
    ): StorageFile {

        var name = "Unknown"
        var size = 0L

        context.contentResolver.query(
            uri,
            null,
            null,
            null,
            null
        )?.use { cursor ->

            val nameIndex =
                cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)

            val sizeIndex =
                cursor.getColumnIndex(OpenableColumns.SIZE)

            if (cursor.moveToFirst()) {

                if (nameIndex >= 0) {
                    name = cursor.getString(nameIndex)
                }

                if (sizeIndex >= 0) {
                    size = cursor.getLong(sizeIndex)
                }
            }
        }

        val mimeType =
            context.contentResolver.getType(uri) ?: "Unknown"

        val extension =
            mimeType.substringAfter("/", "")
        val type = when {

            mimeType.startsWith("image/") -> StorageType.IMAGE

            mimeType.startsWith("video/") -> StorageType.VIDEO

            mimeType.startsWith("audio/") -> StorageType.AUDIO

            mimeType.startsWith("application/pdf") -> StorageType.DOCUMENT

            else -> StorageType.UNKNOWN
        }

        val duration = if (type == StorageType.VIDEO || type == StorageType.AUDIO) {

            runCatching {

                val retriever = MediaMetadataRetriever()

                retriever.setDataSource(context, uri)

                val value = retriever.extractMetadata(
                    MediaMetadataRetriever.METADATA_KEY_DURATION
                )

                retriever.release()

                value?.toLong()

            }.getOrNull()

        } else {

            null
        }
        var width: Int? = null
        var height: Int? = null
        var lastModified: Long? = null

        context.contentResolver.query(
            uri,
            null,
            null,
            null,
            null
        )?.use { cursor ->

            if (cursor.moveToFirst()) {

                val dateIndex =
                    cursor.getColumnIndex(android.provider.MediaStore.MediaColumns.DATE_MODIFIED)

                if (dateIndex >= 0) {
                    lastModified = cursor.getLong(dateIndex) * 1000L
                }
            }
        }
        when (type) {

            StorageType.IMAGE -> {

                val options = android.graphics.BitmapFactory.Options().apply {
                    inJustDecodeBounds = true
                }

                context.contentResolver
                    .openInputStream(uri)
                    ?.use {

                        android.graphics.BitmapFactory.decodeStream(
                            it,
                            null,
                            options
                        )
                    }

                width = options.outWidth
                height = options.outHeight
            }

            StorageType.VIDEO -> {

                val retriever =
                    android.media.MediaMetadataRetriever()

                try {

                    retriever.setDataSource(
                        context,
                        uri
                    )
                    val artist = retriever.extractMetadata(
                        MediaMetadataRetriever.METADATA_KEY_ARTIST
                    )

                    val album = retriever.extractMetadata(
                        MediaMetadataRetriever.METADATA_KEY_ALBUM
                    )

                    val genre = retriever.extractMetadata(
                        MediaMetadataRetriever.METADATA_KEY_GENRE
                    )

                    val year = retriever.extractMetadata(
                        MediaMetadataRetriever.METADATA_KEY_YEAR
                    )

                    val bitrate = retriever.extractMetadata(
                        MediaMetadataRetriever.METADATA_KEY_BITRATE
                    )?.toIntOrNull()

                    val albumArt = retriever.embeddedPicture?.let {

                        BitmapFactory.decodeByteArray(
                            it,
                            0,
                            it.size
                        )

                    }

                    width = retriever.extractMetadata(
                        android.media.MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH
                    )?.toInt()

                    height = retriever.extractMetadata(
                        android.media.MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT
                    )?.toInt()

                } finally {

                    retriever.release()
                }
            }

            else -> Unit
        }



        return StorageFile(
            uri = uri,
            name = name,
            size = size,
            mimeType = mimeType,
            type = type,
            duration = duration,
            width = width,
            height = height,
            lastModified = lastModified,
            artist = null,
            album = null,
            genre = null,
            year = null,
            bitrate = null,
            albumArt = null


        )
    }
}