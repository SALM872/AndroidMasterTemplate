package com.bright.core.logger

import android.util.Log

object BrightLogger {

    private const val TAG = "BrightSDK"

    fun d(message: String) = Log.d(TAG, message)

    fun i(message: String) = Log.i(TAG, message)

    fun e(message: String) = Log.e(TAG, message)

    fun w(message: String) = Log.w(TAG, message)
}