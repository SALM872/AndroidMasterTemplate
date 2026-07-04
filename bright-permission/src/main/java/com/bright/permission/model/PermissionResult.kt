package com.bright.permission.model

data class PermissionResult(

    val permission: PermissionType,

    val state: PermissionState

) {

    val isGranted: Boolean
        get() = state == PermissionState.GRANTED

    val isDenied: Boolean
        get() = state == PermissionState.DENIED

    val isPermanentlyDenied: Boolean
        get() = state == PermissionState.PERMANENTLY_DENIED

}