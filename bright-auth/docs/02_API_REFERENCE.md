# BrightStorage API Reference

Version: 1.0.0

---

# Introduction

This document describes every public API exposed by BrightStorage.

Each API includes:

- Purpose
- Parameters
- Return Type
- Usage Example
- Expected Result
- Notes

Only APIs intended for application developers are documented here.

Internal classes such as Launchers, Managers, Engines, and Resolvers are intentionally excluded.

---

# Initialization

Before using any BrightStorage feature, the library must be initialized.

Initialization registers all required Activity Result launchers and prepares the internal storage infrastructure.

---

## initialize()

### Signature

```kotlin
BrightStorage.initialize(
    activity = activity
)
```

### Parameters

| Parameter | Type | Required |
|----------|------|----------|
| activity | ComponentActivity | Yes |
| config | StorageConfig | Optional |

---

### Example

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

---

### Returns

No return value.

---

### Notes

- Must be called once.
- Should be called before any picker or camera operation.
- Usually placed inside Activity.onCreate().

---

# Image Picker

BrightStorage provides APIs for selecting images from the device gallery.

---

## pickImage()

Select a single image.

### Signature

```kotlin
BrightStorage.pickImage(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickImage { result ->

    when (result) {

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

### Success Result

Returns

```kotlin
StorageResult.Success
```

containing

```kotlin
List<StorageFile>
```

with one image.

---

### Available Metadata

Returned StorageFile may include:

- Uri
- Name
- Display Name
- Extension
- MIME Type
- File Size
- Width
- Height
- Resolution
- Thumbnail
- Last Modified

---

### Notes

Returns exactly one image.

---

## pickImages()

Select multiple images.

### Signature

```kotlin
BrightStorage.pickImages(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickImages { result ->

    when (result) {

        is StorageResult.Success -> {

            val images = result.files

        }

        else -> Unit

    }

}
```

---

### Success Result

Returns

```kotlin
StorageResult.Success
```

containing

```kotlin
List<StorageFile>
```

where every item represents one selected image.

---

### Available Metadata

Each StorageFile contains the same metadata available in pickImage().

---

### Notes

- Supports selecting multiple images.
- Number of returned files depends on user selection.

---

# Video Picker

BrightStorage also supports selecting videos using the same callback architecture.

---

## pickVideo()

Select a single video.

### Signature

```kotlin
BrightStorage.pickVideo(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickVideo { result ->

    when (result) {

        is StorageResult.Success -> {

            val video = result.files.first()

        }

        else -> Unit

    }

}
```

---

### Available Metadata

Returned StorageFile may include:

- Uri
- Name
- Display Name
- Extension
- MIME Type
- File Size
- Duration
- Resolution
- Thumbnail
- Last Modified

---

### Notes

Returns one selected video.

---

## pickVideos()

Select multiple videos.

### Signature

```kotlin
BrightStorage.pickVideos(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickVideos { result ->

    when (result) {

        is StorageResult.Success -> {

            val videos = result.files

        }

        else -> Unit

    }

}
```

---

### Success Result

Returns multiple StorageFile objects representing selected videos.

---

# Document Picker

BrightStorage supports document selection using the Android Storage Access Framework (SAF).

Supported document types depend on the document providers installed on the user's device.

---

## pickDocument()

Select a single document.

### Signature

```kotlin
BrightStorage.pickDocument(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickDocument { result ->

    when (result) {

        is StorageResult.Success -> {

            val document = result.files.first()

        }

        is StorageResult.Cancelled -> {

        }

        is StorageResult.Error -> {

        }

    }

}
```

---

### Available Metadata

Returned StorageFile may contain:

- Uri
- Name
- Display Name
- Extension
- MIME Type
- File Size
- Last Modified

---

### Notes

The returned file may represent:

- PDF
- Word Document
- Excel Spreadsheet
- PowerPoint Presentation
- Text File
- ZIP Archive
- APK
- JSON
- CSV
- XML

depending on the document provider.

---

## pickDocuments()

Select multiple documents.

### Signature

```kotlin
BrightStorage.pickDocuments(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickDocuments { result ->

    when (result) {

        is StorageResult.Success -> {

            val documents = result.files

        }

        else -> Unit

    }

}
```

---

### Success Result

Returns

```kotlin
List<StorageFile>
```

where each item represents one selected document.

---

# Audio Picker

BrightStorage supports selecting audio files from device storage.

---

## pickAudio()

Select a single audio file.

### Signature

```kotlin
BrightStorage.pickAudio(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickAudio { result ->

    when (result) {

        is StorageResult.Success -> {

            val audio = result.files.first()

        }

        else -> Unit

    }

}
```

---

### Available Metadata

StorageFile may include:

- Uri
- Name
- Display Name
- Extension
- MIME Type
- File Size
- Duration
- Artist
- Album
- Genre
- Year
- Bitrate

Metadata availability depends on the selected audio file.

---

## pickAudios()

Select multiple audio files.

### Signature

```kotlin
BrightStorage.pickAudios(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.pickAudios { result ->

    when (result) {

        is StorageResult.Success -> {

            val audioFiles = result.files

        }

        else -> Unit

    }

}
```

---

### Success Result

Returns multiple StorageFile objects.

---

# Camera Capture

BrightStorage also supports direct camera capture.

No manual camera intent handling is required.

---

## captureImage()

Launch the device camera to capture a photo.

### Signature

```kotlin
BrightStorage.captureImage(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.captureImage { result ->

    when (result) {

        is StorageResult.Success -> {

            val image = result.files.first()

        }

        else -> Unit

    }

}
```

---

### Returned Metadata

Captured images provide the same metadata as gallery images whenever available.

---

### Notes

BrightStorage automatically manages:

- Temporary file creation
- FileProvider
- Content URI generation
- Metadata extraction

No manual implementation is required.

---

## captureVideo()

Launch the device camera to record a video.

### Signature

```kotlin
BrightStorage.captureVideo(
    callback = { result -> }
)
```

---

### Example

```kotlin
BrightStorage.captureVideo { result ->

    when (result) {

        is StorageResult.Success -> {

            val video = result.files.first()

        }

        else -> Unit

    }

}
```

---

### Returned Metadata

Returned StorageFile may contain:

- Uri
- Name
- MIME Type
- File Size
- Duration
- Resolution
- Thumbnail

depending on device capabilities.

---

### Notes

BrightStorage automatically creates the destination file before launching the camera.

---

# StorageResult

Every BrightStorage operation returns a StorageResult.

This sealed class represents the final state of a storage operation.

Possible results include:

- Success
- Cancelled
- Error

---

## Success

Returned when the requested operation completes successfully.

Example:

```kotlin
is StorageResult.Success -> {

    val files = result.files

}
```

The returned list may contain one or multiple StorageFile objects depending on the API used.

---

## Cancelled

Returned when the user closes the picker or camera without selecting or capturing a file.

Example:

```kotlin
is StorageResult.Cancelled -> {

    // User cancelled the operation

}
```

---

## Error

Returned when BrightStorage encounters an unexpected error.

Example:

```kotlin
is StorageResult.Error -> {

    Log.e(
        "BrightStorage",
        result.exception.message
    )

}
```

---

# StorageFile

StorageFile is the unified model used throughout BrightStorage.

Every picker and camera API returns one or more StorageFile objects.

---

## Common Properties

Depending on the selected file type, StorageFile may contain:

- Uri
- Name
- Display Name
- Extension
- MIME Type
- File Size
- Type
- Width
- Height
- Resolution
- Duration
- Thumbnail
- Artist
- Album
- Genre
- Year
- Bitrate
- Last Modified

Properties that are not applicable for a particular media type may be null.

---

# StorageConfig

StorageConfig allows developers to customize library behavior during initialization.

Example:

```kotlin
BrightStorage.initialize(
    activity = this,
    config = StorageConfig()
)
```

Future versions may introduce additional configuration options without changing the public APIs.

---

# Error Handling

Applications should always handle all possible StorageResult states.

Recommended pattern:

```kotlin
BrightStorage.pickImage { result ->

    when (result) {

        is StorageResult.Success -> {

            // Process files

        }

        is StorageResult.Cancelled -> {

            // User cancelled

        }

        is StorageResult.Error -> {

            // Handle error

        }

    }

}
```

Ignoring Cancelled or Error states is not recommended.

---

# Best Practices

The following practices are recommended when using BrightStorage.

- Initialize the library once during Activity creation.
- Always handle all StorageResult states.
- Avoid storing temporary Uri values longer than necessary.
- Check metadata values for null before displaying them.
- Use readable formatting helpers for file size and duration.
- Reuse StorageFile instead of extracting metadata repeatedly.

---

# Performance Notes

BrightStorage resolves metadata only when required.

Metadata extraction depends on the selected file type.

For example:

Images

- Resolution
- Thumbnail

Videos

- Duration
- Resolution
- Thumbnail

Audio

- Artist
- Album
- Genre
- Duration

Documents

- Name
- MIME Type
- Size

This approach minimizes unnecessary processing while keeping the API consistent.

---

# Threading

BrightStorage callbacks are designed to be simple and predictable.

Developers should perform heavy processing, uploads, or file parsing outside the callback when appropriate.

---

# Compatibility

BrightStorage is built using modern Android APIs and is intended for current Android development.

Compatibility depends on:

- Android Storage Access Framework
- Activity Result APIs
- MediaStore
- FileProvider

Behavior may vary depending on the Android version and the document providers available on the user's device.

---

# Public API Summary

BrightStorage currently exposes the following public APIs.

Initialization

- initialize()

Image

- pickImage()
- pickImages()

Video

- pickVideo()
- pickVideos()

Document

- pickDocument()
- pickDocuments()

Audio

- pickAudio()
- pickAudios()

Camera

- captureImage()
- captureVideo()

---

# Design Principles

Every public API follows the same philosophy.

- Simple to understand.
- Consistent naming.
- Predictable callbacks.
- Unified result model.
- Minimal Android boilerplate.

This consistency allows developers to learn one API pattern and apply it across all supported storage types.

---

# Conclusion

BrightStorage provides a single, unified API for Android storage operations.

Regardless of whether the application works with images, videos, documents, audio files, or camera capture, developers interact with the same architecture, callback model, and StorageFile representation.

This consistency reduces learning time, improves maintainability, and enables applications to scale without introducing separate implementations for each media type.