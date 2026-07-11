package com.bright.storage.extensions

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.os.Build
import android.provider.MediaStore
import com.bright.storage.builder.StorageType
import com.bright.storage.model.StorageFile

fun StorageFile.loadThumbnail(
    context: Context
): Bitmap? {

    return loadThumbnail(
        context = context,
        size = ThumbnailSize.MEDIUM
    )

}

fun StorageFile.loadThumbnail(
    context: Context,
    size: ThumbnailSize
): Bitmap? {

    return loadThumbnail(
        context = context,
        width = size.width,
        height = size.height
    )

}
fun StorageFile.loadThumbnail(
    context: Context,
    width: Int,
    height: Int
): Bitmap? {

    if (type == StorageType.IMAGE) {

        return try {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                context.contentResolver.loadThumbnail(
                    uri,
                    android.util.Size(width, height),
                    null
                )

            } else {

                MediaStore.Images.Media.getBitmap(
                    context.contentResolver,
                    uri
                )

            }

        } catch (e: Exception) {

            null
        }

    }

    if (type == StorageType.VIDEO) {

        return try {

            val retriever = MediaMetadataRetriever()

            retriever.setDataSource(
                context,
                uri
            )

            val bitmap = retriever.frameAtTime

            retriever.release()

            bitmap

        } catch (e: Exception) {

            null
        }

    }

    return null

}
