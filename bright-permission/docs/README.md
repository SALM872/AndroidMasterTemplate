# BrightPermission

A lightweight, reusable Android Runtime Permission library built with Kotlin and the Android Activity Result API.

BrightPermission simplifies runtime permission handling by providing a clean API for requesting permissions, checking permission status and handling permanently denied permissions.

---

# Features

## Single Permission

Request a single runtime permission.

Example

```kotlin
BrightPermission.request(
    PermissionType.CAMERA
) { result ->

}
```

---

## Multiple Permissions

Request multiple permissions using a single API.

Example

```kotlin
BrightPermission.request(

    PermissionType.CAMERA,
    PermissionType.MICROPHONE,
    PermissionType.STORAGE

) { results ->

}
```

---

## Permission States

BrightPermission automatically detects:

- GRANTED
- DENIED
- PERMANENTLY_DENIED

---

## Check Existing Permission

```kotlin
BrightPermission.hasPermission(
    context,
    PermissionType.CAMERA
)
```

Returns

```kotlin
Boolean
```

---

## Open App Settings

If a permission is permanently denied:

```kotlin
BrightPermission.openSettings(context)
```

---

# Public API

- initialize()
- request()
- hasPermission()
- openSettings()

For complete API documentation see:

API_REFERENCE.md

---

# Architecture

See

ARCHITECTURE.md

---

# Design Decisions

See

DESIGN_DECISIONS.md

---

# Future Features

See

ROADMAP.md

---

# Current Status

Version

v1.0.0

Status

✅ Stable

JitPack Ready

Yes

---

# Requirements

- Kotlin
- AndroidX Activity Result API
- Android Runtime Permissions

---

# License

MIT License