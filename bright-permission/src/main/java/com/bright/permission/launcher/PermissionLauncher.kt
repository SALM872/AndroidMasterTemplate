package com.bright.permission.launcher

import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

internal class PermissionLauncher(

    activity: ComponentActivity,

    private val singleCallback: (Boolean) -> Unit,

    private val multipleCallback: (Map<String, Boolean>) -> Unit

) {

    private val singleLauncher: ActivityResultLauncher<String> =
        activity.registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->

            singleCallback(granted)

        }

    private val multipleLauncher: ActivityResultLauncher<Array<String>> =
        activity.registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { result ->

            multipleCallback(result)

        }

    fun launch(
        permission: String
    ) {

        singleLauncher.launch(permission)

    }

    fun launch(
        permissions: Array<String>
    ) {

        multipleLauncher.launch(permissions)

    }

}