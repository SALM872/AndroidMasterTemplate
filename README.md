# AndroidMasterTemplate

A reusable Android SDK Factory built with Kotlin, Jetpack Compose and Modern Android Development.

This repository is **not a normal Android application**.

It is a multi-module Android Library Factory where every reusable library is developed, tested, documented and published through **GitHub + JitPack**.

---

# Vision

Build a collection of production-ready Android SDKs that can be reused across multiple Android projects with a clean architecture, consistent API design and professional documentation.

---

# Current Modules

## bright-core

Common reusable utilities shared across all Bright SDK modules.

### Features

- Result Wrapper
- Logger
- Utilities
- Common Helpers

Status

✅ Stable

---

## bright-room

A lightweight wrapper around Android Room.

### Features

- BaseDao
- BaseRepository
- BaseEntity
- BrightRoom Builder
- BrightRoomConfig
- Generic CRUD
- Flow Support
- Bulk Insert
- Bulk Update
- Bulk Delete
- JitPack Ready

### Tested

- Insert
- Read
- Update
- Delete

Status

✅ Stable

---

## bright-permission

A modern Android Runtime Permission library with a simple and developer-friendly API.

### Features

- Single Permission Request
- Multiple Permission Request
- Permission State Detection
- Permanently Denied Detection
- Open App Settings
- Permission Validator
- Permission State Resolver
- Clean Permission Engine
- JitPack Ready

### Supported Results

- GRANTED
- DENIED
- PERMANENTLY_DENIED

Status

✅ Stable

---

# Sample Application

The **app** module exists only for testing Bright SDK modules.

It is **not production code**.

Every library is fully tested inside this application before being published.

---

# Documentation Standard

Every Bright SDK module follows the same documentation structure.

- README.md
- CHANGELOG.md
- ROADMAP.md
- API_REFERENCE.md
- ARCHITECTURE.md
- DESIGN_DECISIONS.md
- LICENSE
- .gitignore

---

# Future Modules

- BrightImagePicker
- BrightNetwork
- BrightCamera
- BrightStorage
- BrightFirebase
- BrightLocation
- BrightNotification
- BrightPreferences
- BrightMedia
- BrightCompose

---

# Publish Flow

Library

↓

Testing

↓

Documentation

↓

GitHub

↓

JitPack

↓

Dependency

↓

Real Project

---

# Current Version

v1.1.0

---

# License

This project is licensed under the MIT License.