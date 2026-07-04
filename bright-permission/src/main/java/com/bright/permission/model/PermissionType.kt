package com.bright.permission.model

import android.Manifest

enum class PermissionType(
    val value: String
) {

    CAMERA(Manifest.permission.CAMERA),

    LOCATION(Manifest.permission.ACCESS_FINE_LOCATION),

    STORAGE(Manifest.permission.READ_MEDIA_IMAGES),

    MICROPHONE(Manifest.permission.RECORD_AUDIO),

    CONTACTS(Manifest.permission.READ_CONTACTS),

    NOTIFICATION(Manifest.permission.POST_NOTIFICATIONS)

}