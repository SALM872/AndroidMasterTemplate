package com.bright.permission.internal

import android.content.Context
import androidx.activity.ComponentActivity
import com.bright.permission.launcher.PermissionLauncher
import com.bright.permission.model.PermissionResult
import com.bright.permission.model.PermissionResults
import com.bright.permission.model.PermissionType

internal object PermissionEngine {

    private var activity: ComponentActivity? = null

    private var launcher: PermissionLauncher? = null

    private var currentPermission: PermissionType? = null

    private var callback: ((PermissionResult) -> Unit)? = null

    fun initialize(
        activity: ComponentActivity
    ) {

        this.activity = activity

        launcher = PermissionLauncher(

            activity = activity,

            singleCallback = { granted ->

                val permission = currentPermission ?: return@PermissionLauncher

                callback?.invoke(

                    PermissionStateResolver.resolve(
                        activity = activity,
                        permission = permission,
                        granted = granted
                    )

                )

            },

            multipleCallback = { result ->

                MultiplePermissionEngine.dispatchResult(result)

            }

        )

        MultiplePermissionEngine.initialize(
            activity = activity,
            launcher = launcher!!
        )

    }

    fun hasPermission(
        context: Context,
        permission: PermissionType
    ): Boolean {

        return PermissionValidator.isGranted(
            activity = context as ComponentActivity,
            permission = permission
        )

    }

    fun request(
        permission: PermissionType,
        onResult: (PermissionResult) -> Unit
    ) {

        val activity = PermissionValidator.requireInitialized(activity)

        if (PermissionValidator.isGranted(activity, permission)) {

            onResult(

                PermissionStateResolver.resolve(
                    activity = activity,
                    permission = permission,
                    granted = true
                )

            )

            return

        }

        currentPermission = permission

        callback = onResult

        launcher?.launch(permission.value)

    }

    fun request(
        permissions: Array<out PermissionType>,
        onResult: (PermissionResults) -> Unit
    ) {

        MultiplePermissionEngine.request(
            permissions = permissions,
            onResult = onResult
        )

    }

}