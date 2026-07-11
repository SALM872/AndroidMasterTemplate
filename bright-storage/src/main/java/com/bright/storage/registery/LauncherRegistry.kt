package com.bright.storage.registry

import androidx.activity.ComponentActivity
import com.bright.storage.launcher.AudioPickerLauncher
import com.bright.storage.launcher.CameraImageLauncher
import com.bright.storage.launcher.CameraVideoLauncher
import com.bright.storage.launcher.DocumentPickerLauncher
import com.bright.storage.launcher.ImagePickerLauncher
import com.bright.storage.launcher.MultipleAudioPickerLauncher
import com.bright.storage.launcher.MultipleDocumentPickerLauncher
import com.bright.storage.launcher.MultipleImagePickerLauncher
import com.bright.storage.launcher.MultipleVideoPickerLauncher
import com.bright.storage.launcher.VideoPickerLauncher

internal object LauncherRegistry {

    private lateinit var activity: ComponentActivity

    fun register(
        activity: ComponentActivity
    ) {

        this.activity = activity
        ImagePickerLauncher.register(activity)

        MultipleImagePickerLauncher.register(activity)

        VideoPickerLauncher.register(activity)

        MultipleVideoPickerLauncher.register(activity)
        DocumentPickerLauncher.register(activity)

        MultipleDocumentPickerLauncher.register(activity)
        AudioPickerLauncher.register(activity)

        MultipleAudioPickerLauncher.register(activity)
        CameraImageLauncher.register(activity)

        CameraVideoLauncher.register(activity)

        // Next step me saare launchers yahin register honge.

    }

    fun getActivity(): ComponentActivity {

        return activity

    }

}