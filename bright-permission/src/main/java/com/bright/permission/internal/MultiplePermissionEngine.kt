package com.bright.permission.internal

import androidx.activity.ComponentActivity
import com.bright.permission.launcher.PermissionLauncher
import com.bright.permission.model.PermissionResult
import com.bright.permission.model.PermissionResults
import com.bright.permission.model.PermissionType

internal object MultiplePermissionEngine {

    private var activity: ComponentActivity? = null

    private var launcher: PermissionLauncher? = null

    private var callback: ((PermissionResults) -> Unit)? = null

    private var currentPermissions: Array<out PermissionType>? = null

    fun initialize(
        activity: ComponentActivity,
        launcher: PermissionLauncher
    ) {

        this.activity = activity
        this.launcher = launcher

    }

    fun request(
        permissions: Array<out PermissionType>,
        onResult: (PermissionResults) -> Unit
    ) {

        val activity = PermissionValidator.requireInitialized(activity)

        currentPermissions =
            PermissionValidator.validatePermissions(permissions)

        callback = onResult

        launcher?.launch(

            currentPermissions!!
                .map { it.value }
                .toTypedArray()

        )

    }

    fun dispatchResult(
        result: Map<String, Boolean>
    ) {

        val activity = activity ?: return

        val permissionMap = mutableMapOf<PermissionType, PermissionResult>()

        currentPermissions?.forEach { permission ->

            val granted = result[permission.value] ?: false

            permissionMap[permission] =

                PermissionStateResolver.resolve(
                    activity = activity,
                    permission = permission,
                    granted = granted
                )

        }

        callback?.invoke(

            PermissionResults(permissionMap)

        )

    }

}