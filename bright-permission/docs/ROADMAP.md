# BrightPermission Roadmap

This document contains the future vision and planned features for the BrightPermission library.

---

# Current Version

v1.0.0

Status

✅ Stable

---

# Completed Features

## Core

- Runtime Permission Engine
- Permission Manager
- Permission Launcher
- Permission Validator
- Permission State Resolver
- Settings Helper

---

## Permission Types

- Single Permission Request
- Multiple Permission Request

---

## Permission States

- GRANTED
- DENIED
- PERMANENTLY_DENIED

---

## Public APIs

- initialize()
- request(permission)
- request(vararg permissions)
- hasPermission()
- openSettings()

---

# Version 1.1.0

Status

🟡 Planned

### Sequential Permission Request

Request permissions one after another.

Example

CAMERA

↓

MICROPHONE

↓

NOTIFICATION

Benefits

- Better user experience
- Higher permission acceptance rate
- Google recommended flow

---

### Permission Groups

Example

PermissionGroup.MEDIA

Automatically requests

- Camera
- Gallery
- Microphone

---

### Compose Extensions

Example

rememberPermissionState()

PermissionButton()

PermissionCard()

---

# Version 1.2.0

Status

🟡 Planned

### Custom Permission Dialog

Developer can show a custom explanation dialog before requesting permission.

---

### Permission Callback Improvements

- Success callback
- Denied callback
- Permanently Denied callback

---

### Batch Permission APIs

Advanced APIs for enterprise applications.

---

# Version 1.3.0

Status

🟡 Planned

### Analytics

Track

- Granted Count
- Denied Count
- Permanently Denied Count

---

### Permission History

Store previously requested permissions.

---

### Permission Retry Policy

Automatically retry permission requests when appropriate.

---

# Version 2.0.0

Status

🔵 Vision

### Compose First API

Native Compose APIs.

---

### OEM Compatibility Layer

Handle manufacturer-specific permission behavior.

Examples

- Xiaomi
- Oppo
- Vivo
- Samsung
- Realme

---

### Smart Permission Engine

Automatically

- Skip Granted Permissions
- Detect Permanently Denied
- Optimize Request Order

---

### Permission Dashboard

Developer tools for debugging permissions.

---

### Permission Analytics Dashboard

Visual statistics for permission requests.

---

# Long-Term Vision

BrightPermission aims to become a complete Android Runtime Permission SDK that is:

- Lightweight
- Modular
- Easy to Use
- Jetpack Compose Friendly
- Enterprise Ready
- JitPack Ready
- Production Ready

---

# Notes

Any completed feature should be moved from the Planned section to the Completed section in the next release.