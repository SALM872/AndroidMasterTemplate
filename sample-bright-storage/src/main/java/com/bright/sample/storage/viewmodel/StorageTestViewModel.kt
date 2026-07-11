package com.bright.sample.storage.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bright.storage.api.BrightStorage
import com.bright.storage.model.StorageFile
import com.bright.storage.model.StorageResult

class StorageTestViewModel : ViewModel() {

    var files by mutableStateOf<List<StorageFile>>(emptyList())
        private set
    var message by mutableStateOf("No File Selected")
        private set

    fun pickImage() {

        BrightStorage.pickImage { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "Image Selected Successfully"
                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"
                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"
                }
            }
        }
    }

    fun pickVideo() {

        BrightStorage.pickVideo { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "Video Selected Successfully"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }
            }
        }
    }

    fun pickImages() {

        BrightStorage.pickImages { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "${result.files.size} Images Selected"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }
            }
        }
    }
    fun pickVideos() {

        BrightStorage.pickVideos { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "${result.files.size} Videos Selected"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }
            }
        }
    }
    fun pickDocument() {

        BrightStorage.pickDocument { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "Document Selected Successfully"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }
            }
        }
    }

    fun pickDocuments() {

        BrightStorage.pickDocuments { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "${result.files.size} Documents Selected"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }
            }
        }
    }
    fun pickAudio() {

        BrightStorage.pickAudio { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "Audio Selected Successfully"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }

            }

        }

    }
    fun pickAudios() {

        BrightStorage.pickAudios { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "${result.files.size} Audio Files Selected"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }

            }

        }

    }
    fun captureImage() {

        BrightStorage.captureImage { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "Image Captured Successfully"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }

            }

        }

    }

    fun captureVideo() {

        BrightStorage.captureVideo { result ->

            when (result) {

                is StorageResult.Success -> {

                    files = result.files
                    message = "Video Captured Successfully"

                }

                is StorageResult.Error -> {

                    message = result.exception.message ?: "Unknown Error"

                }

                is StorageResult.Cancelled -> {

                    message = "User Cancelled"

                }

            }

        }

    }

}