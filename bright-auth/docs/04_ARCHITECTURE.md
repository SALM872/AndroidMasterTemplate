# BrightStorage Architecture

Version: 1.0.0

---

# Introduction

BrightStorage follows a layered architecture designed for simplicity, maintainability, and scalability.

Instead of placing all logic inside a single class, responsibilities are divided into dedicated layers.

Each layer performs one specific task and communicates only with the next layer.

This architecture keeps the library easy to maintain while allowing future features to be added without breaking existing APIs.

---

# Architecture Overview

Every storage operation follows the same execution flow.

```
Application

        │

        ▼

BrightStorage (Public API)

        │

        ▼

StorageEngine

        │

        ▼

Feature Engine

(Image / Video / Audio / Document / Camera)

        │

        ▼

Launcher

(Activity Result Contracts)

        │

        ▼

Android Framework

        │

        ▼

StorageFileResolver

        │

        ▼

StorageFile

        │

        ▼

StorageResult

        │

        ▼

Application Callback
```

---

# Package Responsibilities

## api

Contains only public APIs.

Example:

- BrightStorage

No Android framework code should exist here.

---

## builder

Contains configuration classes.

Examples:

- StorageConfig
- CameraConfig

Builders allow future customization while keeping public APIs stable.

---

## callback

Contains callback interfaces.

Example:

- StorageCallback

All picker and camera operations communicate using callbacks defined here.

---

## engine

Coordinates library operations.

Examples:

- StorageEngine
- CameraEngine
- AudioPickerEngine
- VideoPickerEngine
- DocumentPickerEngine

The Engine layer decides which launcher should execute a request.

Business logic should remain here rather than inside Launchers.

---

## launcher

Responsible for Android Activity Result APIs.

Examples:

- ImagePickerLauncher
- MultipleImagePickerLauncher
- VideoPickerLauncher
- CameraImageLauncher
- CameraVideoLauncher
- AudioPickerLauncher
- DocumentPickerLauncher

Launchers should never contain business logic.

Their only responsibility is interacting with Android.

---

## manager

Responsible for initialization and internal state.

Examples:

- StorageManager
- CameraManager

Managers store configuration and shared resources.

---

## util

Contains reusable helper classes.

Examples:

- StorageFileResolver
- StorageFormatter

Utilities should remain independent from UI and Android lifecycle.

---

## model

Contains shared data models.

Examples:

- StorageFile
- StorageResult
- StorageException

These models are shared across every storage operation.

---

## extensions

Contains extension functions that improve usability.

Examples:

- Thumbnail Extensions
- Formatter Extensions
- Display Extensions

Extensions provide convenience APIs without increasing library complexity.

---

# Layer Communication

Communication always flows downward.

```
Application

↓

API

↓

Engine

↓

Launcher

↓

Android

↓

Resolver

↓

Model

↓

Callback
```

Higher layers never depend on lower implementation details.

This makes internal refactoring much safer.

---

# StorageFileResolver

StorageFileResolver is responsible for converting Android Uri objects into StorageFile models.

Responsibilities include:

- Display Name
- MIME Type
- Extension
- File Size
- Resolution
- Duration
- Audio Metadata
- Thumbnail
- Last Modified

Future versions may split metadata extraction into dedicated resolver classes while preserving the same public API.

---

# StorageFile

StorageFile acts as the unified representation of every selected file.

Regardless of whether the file is:

- Image
- Video
- Audio
- Document
- Camera Capture

the application receives the same StorageFile model.

This greatly simplifies application code.

---

# Callback Flow

Every operation returns a StorageResult.

Possible outcomes include:

- Success
- Cancelled
- Error

Applications never interact directly with Android Activity Results.

BrightStorage converts Android callbacks into StorageResult objects.

---

# Why This Architecture?

This design provides several benefits.

## Consistency

Every feature follows the same architecture.

---

## Maintainability

Each class has one responsibility.

---

## Reusability

Launchers, Resolvers, and Models can be reused across multiple features.

---

## Scalability

Future storage types can be added without redesigning the existing architecture.

Examples:

- Folder Picker
- Cloud Upload
- CameraX
- Compose Components

---

## Testability

Business logic is separated from Android framework code wherever possible.

This improves long-term maintainability.

---

# Internal Principles

BrightStorage follows several engineering principles.

- Single Responsibility Principle
- Clean Architecture
- Minimal Public API
- Consistent Naming
- Internal Abstraction
- Reusable Components
- Backward Compatibility

These principles guide every future feature added to the project.

---

# Future Architecture

Version 1 establishes the core storage platform.

Future versions will extend the architecture while preserving existing public APIs.

Potential additions include:

- Folder Picker
- Persistable URI Permissions
- Storage Observer
- Cloud Upload
- CameraX
- Compose Components
- Advanced Metadata Extraction

The layered architecture was intentionally designed to support these future capabilities without major restructuring.

---

# Conclusion

BrightStorage is designed around a layered architecture that separates responsibilities, minimizes Android-specific boilerplate, and provides developers with a clean and predictable API.

Every feature follows the same architectural flow, ensuring consistency, maintainability, and long-term scalability.