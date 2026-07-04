package com.bright.permission.internal

import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import com.bright.permission.model.PermissionType

internal object PermissionValidator {

    fun requireInitialized(
        activity: ComponentActivity?
    ): ComponentActivity {

        return checkNotNull(activity) {
            "BrightPermission.initialize() must be called first."
        }

    }

    fun isGranted(
        activity: ComponentActivity,
        permission: PermissionType
    ): Boolean {

        return ContextCompat.checkSelfPermission(
            activity,
            permission.value
        ) == PackageManager.PERMISSION_GRANTED

    }

    fun validatePermissions(
        permissions: Array<out PermissionType>
    ): Array<out PermissionType> {

        require(permissions.isNotEmpty()) {
            "At least one permission is required."
        }

        return permissions.distinct().toTypedArray()

    }

}