package com.bright.permission.manager

import androidx.activity.ComponentActivity
import com.bright.permission.internal.PermissionEngine
import com.bright.permission.model.PermissionResult
import com.bright.permission.model.PermissionResults
import com.bright.permission.model.PermissionType

internal object PermissionManager {

    fun initialize(
        activity: ComponentActivity
    ) {

        PermissionEngine.initialize(activity)

    }

    fun request(
        permission: PermissionType,
        onResult: (PermissionResult) -> Unit
    ) {

        PermissionEngine.request(
            permission = permission,
            onResult = onResult
        )

    }

    fun request(
        vararg permissions: PermissionType,
        onResult: (PermissionResults) -> Unit
    ) {

        PermissionEngine.request(
            permissions = permissions,
            onResult = onResult
        )

    }

}