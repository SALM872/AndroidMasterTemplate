# BrightStorage Setup Guide

Version: 1.0.0

---

# Introduction

This guide explains how to integrate BrightStorage into an Android application.

By the end of this guide you will be able to:

- Install BrightStorage
- Initialize the library
- Pick images
- Pick videos
- Pick documents
- Pick audio
- Capture images
- Capture videos

---

# Requirements

BrightStorage requires the following minimum environment.

| Requirement | Version |
|-------------|----------|
| Android Studio | Latest Stable |
| Kotlin | 2.x |
| Android Gradle Plugin | 8.x or higher |
| Min SDK | 24 |
| Target SDK | Latest Stable |

---

# Installation

Add the BrightStorage dependency.

```kotlin
implementation("com.github.YOUR_USERNAME:BrightStorage:1.0.0")
```

Sync Gradle.

---

# Initialize BrightStorage

Initialize BrightStorage once inside your Activity.

Example:

```kotlin
class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        BrightStorage.initialize(
            activity = this
        )

    }

}
```

Initialization should only happen once.

---

# Basic Image Picker

```kotlin
BrightStorage.pickImage { result ->

    when(result){

        is StorageResult.Success -> {

            val image = result.files.first()

        }

        is StorageResult.Cancelled -> {

        }

        is StorageResult.Error -> {

        }

    }

}
```

---

# Multiple Image Picker

```kotlin
BrightStorage.pickImages { result ->

    when(result){

        is StorageResult.Success -> {

            val images = result.files

        }

        else -> Unit

    }

}
```

---

# Video Picker

```kotlin
BrightStorage.pickVideo { result ->

    when(result){

        is StorageResult.Success -> {

            val video = result.files.first()

        }

        else -> Unit

    }

}
```

---

# Multiple Video Picker

```kotlin
BrightStorage.pickVideos { result ->

    when(result){

        is StorageResult.Success -> {

            val videos = result.files

        }

        else -> Unit

    }

}
```

---

# Document Picker

```kotlin
BrightStorage.pickDocument { result ->

    when(result){

        is StorageResult.Success -> {

            val document = result.files.first()

        }

        else -> Unit

    }

}
```

---

# Multiple Document Picker

```kotlin
BrightStorage.pickDocuments { result ->

    when(result){

        is StorageResult.Success -> {

            val documents = result.files

        }

        else -> Unit

    }

}
```

---

# Audio Picker

```kotlin
BrightStorage.pickAudio { result ->

    when(result){

        is StorageResult.Success -> {

            val audio = result.files.first()

        }

        else -> Unit

    }

}
```

---

# Multiple Audio Picker

```kotlin
BrightStorage.pickAudios { result ->

    when(result){

        is StorageResult.Success -> {

            val audios = result.files

        }

        else -> Unit

    }

}
```

---

# Capture Image

```kotlin
BrightStorage.captureImage { result ->

    when(result){

        is StorageResult.Success -> {

            val image = result.files.first()

        }

        else -> Unit

    }

}
```

---

# Capture Video

```kotlin
BrightStorage.captureVideo { result ->

    when(result){

        is StorageResult.Success -> {

            val video = result.files.first()

        }

        else -> Unit

    }

}
```

---

# Working With StorageFile

Every successful operation returns one or more StorageFile objects.

Example:

```kotlin
val file = result.files.first()

println(file.name)

println(file.mimeType)

println(file.size)

println(file.uri)

println(file.type)
```

Additional metadata is available depending on the selected media type.

Examples include:

- Duration
- Resolution
- Artist
- Album
- Genre
- Thumbnail

---

# Error Handling

Always handle every StorageResult state.

```kotlin
when(result){

    is StorageResult.Success -> {}

    is StorageResult.Cancelled -> {}

    is StorageResult.Error -> {}

}
```

---

# Best Practices

- Initialize BrightStorage once.
- Always handle Success, Cancelled and Error.
- Check nullable metadata before use.
- Reuse StorageFile instead of repeatedly resolving metadata.
- Avoid keeping temporary camera files longer than necessary.

---

# Next Steps

After completing the setup guide, continue with:

- API Reference
- Architecture Guide
- Roadmap

These documents explain the internal architecture and advanced capabilities of BrightStorage.