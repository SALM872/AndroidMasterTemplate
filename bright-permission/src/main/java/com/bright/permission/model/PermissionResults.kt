package com.bright.permission.model

data class PermissionResults(

    val results: Map<PermissionType, PermissionResult>

) {

    operator fun get(
        permission: PermissionType
    ): PermissionResult? {

        return results[permission]

    }

    fun allGranted(): Boolean {

        return results.values.all {
            it.isGranted
        }

    }

    fun anyDenied(): Boolean {

        return results.values.any {
            it.isDenied
        }

    }

    fun anyPermanentlyDenied(): Boolean {

        return results.values.any {
            it.isPermanentlyDenied
        }

    }

    fun grantedPermissions(): List<PermissionType> {

        return results.values
            .filter {
                it.isGranted
            }
            .map {
                it.permission
            }

    }

    fun deniedPermissions(): List<PermissionType> {

        return results.values
            .filter {
                it.isDenied
            }
            .map {
                it.permission
            }

    }

    fun permanentlyDeniedPermissions(): List<PermissionType> {

        return results.values
            .filter {
                it.isPermanentlyDenied
            }
            .map {
                it.permission
            }

    }

}