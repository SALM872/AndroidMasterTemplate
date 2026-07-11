# AI Context

Project: BrightStorage

Version: 1.0.0

---

# Purpose

BrightStorage is a reusable Android storage framework built using Kotlin.

The library provides a unified API for working with Android storage while hiding Android-specific implementation details from application developers.

The project is designed around clean architecture, predictable APIs, and long-term maintainability.

This document serves as the permanent engineering context for both human contributors and AI assistants.

---

# Core Philosophy

BrightStorage is **not** intended to be just another media picker.

Its goal is to become a complete Android Storage Framework.

Every storage-related operation should eventually be accessible through one consistent public API.

Developers should never need to understand Android storage internals to use the library.

---

# Primary Goals

The library prioritizes:

- Simplicity
- Consistency
- Stability
- Reusability
- Backward Compatibility

Developer experience always takes precedence over exposing Android implementation details.

---

# Public API Philosophy

Only a very small number of classes should be public.

Current public entry point:

```
BrightStorage
```

Supporting public models:

```
StorageFile

StorageResult

StorageConfig
```

Everything else should remain internal unless a strong reason exists.

Avoid exposing internal implementation classes.

---

# Internal Architecture

Every operation follows the same flow.

```
Application

↓

BrightStorage

↓

StorageEngine

↓

Feature Engine

↓

Launcher

↓

Android Framework

↓

StorageFileResolver

↓

StorageFile

↓

StorageResult

↓

Application
```

No feature should bypass this architecture.

Consistency is considered more important than minimizing class count.

---

# Package Responsibilities

api

Public APIs only.

No Android implementation.

---

builder

Configuration classes.

Examples:

StorageConfig

CameraConfig

---

callback

Callback interfaces shared across the project.

---

engine

Coordinates operations.

Never communicate directly with Android UI.

---

launcher

Only Activity Result Contracts.

Launchers should never contain business logic.

---

manager

Initialization and shared state.

Managers should never resolve metadata.

---

util

Independent helper classes.

Reusable functionality only.

---

extensions

Extension functions.

No business logic.

---

model

Shared models.

Every storage feature returns StorageFile.

---

registry

Launcher registration.

Centralized registration only.

---

# StorageFile

StorageFile is the most important model in the project.

Every picker and camera operation should eventually produce one or more StorageFile objects.

Future metadata should always be added to StorageFile instead of creating separate result models.

---

# StorageResult

StorageResult represents every possible outcome.

Allowed states:

Success

Cancelled

Error

No feature should invent additional callback states unless absolutely necessary.

---

# Current Features

Version 1 currently supports:

Images

Videos

Documents

Audio

Camera Capture

Metadata Extraction

Thumbnail Generation

Formatter Extensions

Display Extensions

---

# Metadata Philosophy

Metadata extraction should be automatic.

Applications should not manually use:

ContentResolver

MediaMetadataRetriever

ThumbnailUtils

MediaStore

BrightStorage should hide these implementation details.

---

# Camera Philosophy

Developers should never manually configure:

FileProvider

Temporary Files

Camera Contracts

URI Creation

BrightStorage is responsible for camera infrastructure.

---

# API Consistency Rules

All picker APIs should follow the same naming.

Examples:

pickImage()

pickImages()

pickVideo()

pickVideos()

pickDocument()

pickDocuments()

pickAudio()

pickAudios()

captureImage()

captureVideo()

Future APIs must continue this pattern.

---

# Naming Rules

Prefer descriptive names.

Examples:

StorageFile

StorageResult

StorageEngine

CameraManager

ImagePickerLauncher

Avoid abbreviations unless universally understood.

---

# Internal Coding Rules

Every class should have one responsibility.

Avoid mixing:

Android APIs

Metadata extraction

Business logic

Initialization

inside the same class.

Keep layers independent.

---

# Error Handling

Unexpected failures should return:

StorageResult.Error

Never silently ignore exceptions.

Always provide meaningful exception information whenever possible.

---

# Performance Guidelines

Avoid duplicate metadata extraction.

Resolve metadata only once.

Reuse StorageFile.

Avoid unnecessary Bitmap allocations.

Keep heavy operations outside the UI thread whenever possible.

---

# Backward Compatibility

Public APIs should remain stable.

Internal implementations may change freely.

Minor releases should avoid breaking applications.

Breaking API changes belong only in major releases.

---

# Future Refactoring

The following internal improvements are planned.

StorageFileResolver

↓

ImageMetadataResolver

VideoMetadataResolver

AudioMetadataResolver

DocumentMetadataResolver

This refactoring should not affect public APIs.

---

# Planned Features

Future releases may include:

Folder Picker

Persistable URI Permissions

Cloud Upload

CameraX

Storage Observer

Compose Components

Advanced Metadata

PDF Preview

Album Artwork

These features should integrate into the existing architecture rather than introducing new architectural patterns.

---

# Things To Avoid

Avoid exposing Android framework classes publicly.

Avoid creating duplicate APIs.

Avoid feature-specific callback interfaces.

Avoid bypassing StorageEngine.

Avoid tightly coupling Launchers with business logic.

Avoid breaking naming consistency.

---

# AI Instructions

When modifying BrightStorage:

Always preserve architecture.

Never introduce shortcuts that bypass the Engine layer.

Never expose internal implementation classes without strong justification.

Prefer reusable abstractions.

Prefer consistency over cleverness.

Maintain backward compatibility.

Follow existing naming conventions.

Keep Android-specific logic isolated.

If multiple implementation options exist, choose the one that minimizes public API changes.

---

# Long-Term Vision

BrightStorage should eventually become the default storage framework for Android applications.

The project should provide a complete solution for:

Media Selection

Camera Capture

Metadata Extraction

Storage Observation

Cloud Upload

Compose Integration

while maintaining one consistent developer experience.

Every future feature should strengthen this vision rather than expanding the public API unnecessarily.

---

# Final Note

This document is the permanent engineering memory of BrightStorage.

Future contributors and AI assistants should read this file before making architectural decisions.

If implementation details change, this document should be updated to reflect the current design philosophy and long-term direction of the project.