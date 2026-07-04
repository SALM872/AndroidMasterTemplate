package com.bright.permission.internal

import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import com.bright.permission.model.PermissionResult
import com.bright.permission.model.PermissionState
import com.bright.permission.model.PermissionType

internal object PermissionStateResolver {

    fun resolve(
        activity: ComponentActivity,
        permission: PermissionType,
        granted: Boolean
    ): PermissionResult {

        val state = when {

            granted -> {
                PermissionState.GRANTED
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                permission.value
            ) -> {
                PermissionState.DENIED
            }

            else -> {
                PermissionState.PERMANENTLY_DENIED
            }

        }

        return PermissionResult(
            permission = permission,
            state = state
        )

    }

}