package com.bright.permission.api

import android.content.Context
import androidx.activity.ComponentActivity
import com.bright.permission.internal.PermissionEngine
import com.bright.permission.internal.SettingsHelper
import com.bright.permission.manager.PermissionManager
import com.bright.permission.model.PermissionResult
import com.bright.permission.model.PermissionResults
import com.bright.permission.model.PermissionType

object BrightPermission {

    fun initialize(
        activity: ComponentActivity
    ) {

        PermissionManager.initialize(activity)

    }

    fun request(
        permission: PermissionType,
        onResult: (PermissionResult) -> Unit
    ) {

        PermissionManager.request(
            permission = permission,
            onResult = onResult
        )

    }

    fun request(
        vararg permissions: PermissionType,
        onResult: (PermissionResults) -> Unit
    ) {

        PermissionManager.request(
            permissions = permissions,
            onResult = onResult
        )

    }

    fun hasPermission(
        context: Context,
        permission: PermissionType
    ): Boolean {

        return PermissionEngine.hasPermission(
            context = context,
            permission = permission
        )

    }

    fun openSettings(
        context: Context
    ) {

        SettingsHelper.openAppSettings(context)

    }

}