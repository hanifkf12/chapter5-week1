package com.hanifkf12.splashpermission

import android.Manifest

object Permission {
    val PERMISSIONS = arrayOf(
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.CAMERA,
        Manifest.permission.RECEIVE_SMS,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
}