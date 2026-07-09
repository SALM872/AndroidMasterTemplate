package com.bright.demo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PermissionTestViewModel {

    var resultText by mutableStateOf(
        "Press any button to test BrightPermission."
    )
        private set

    fun updateResult(
        text: String
    ) {
        resultText = text
    }
}