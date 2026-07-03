# AndroidMasterTemplate

A reusable Android Library Factory built using Kotlin, Jetpack Compose and Modern Android Development.

This project is NOT a normal Android application.

It is a Factory used to build reusable Android libraries which are later published through GitHub + JitPack.

---

# Current Modules

## bright-core

Contains common reusable classes.

Features

- Result Wrapper
- Logger
- Utilities
- Common Helpers

---

## bright-room

A lightweight wrapper around Android Room.

Features

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

CRUD Tested

- Insert
- Read
- Update
- Delete

---

# Sample Application

The app module exists only for testing reusable libraries.

It is NOT production code.

Every library gets tested inside this app before publishing.

---

# Roadmap

- BrightImagePicker
- BrightPermission
- BrightNetwork
- BrightCamera
- BrightStorage
- BrightFirebase

---

# Publish Flow

Library

↓

GitHub

↓

JitPack

↓

Dependency

↓

Real Project

---

Version

Current Version

v1.0.0