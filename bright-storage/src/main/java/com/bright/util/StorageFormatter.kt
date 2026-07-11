package com.bright.storage.util

import com.bright.storage.model.StorageFile
import java.util.Locale

object StorageFormatter {

    fun formatSize(size: Long): String {

        if (size < 1024) {
            return "$size B"
        }

        if (size < 1024 * 1024) {
            return String.format(
                Locale.getDefault(),
                "%.2f KB",
                size / 1024f
            )
        }

        if (size < 1024 * 1024 * 1024) {
            return String.format(
                Locale.getDefault(),
                "%.2f MB",
                size / (1024f * 1024f)
            )
        }

        return String.format(
            Locale.getDefault(),
            "%.2f GB",
            size / (1024f * 1024f * 1024f)
        )
    }
    fun mimeToExtension(
        mimeType: String
    ): String {

        return mimeType.substringAfter(
            "/",
            ""
        ).uppercase()

    }
    fun isImage(
        file: StorageFile
    ): Boolean {

        return file.mimeType.startsWith("image")

    }
    fun formatDuration(duration: Long?): String {

        if (duration == null) return "--"

        val totalSeconds = duration / 1000

        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60

        return if (hours > 0) {

            String.format(
                "%02d:%02d:%02d",
                hours,
                minutes,
                seconds
            )

        } else {

            String.format(
                "%02d:%02d",
                minutes,
                seconds
            )
        }
    }
    fun formatResolution(
        width: Int?,
        height: Int?
    ): String {

        if (width == null || height == null) {
            return "Unknown"
        }

        return "${width} × ${height}"
    }
    fun formatDate(
        time: Long?
    ): String {

        if (time == null) {
            return "Unknown"
        }

        val formatter = java.text.SimpleDateFormat(
            "dd MMM yyyy",
            java.util.Locale.getDefault()
        )

        return formatter.format(
            java.util.Date(time)
        )
    }

}