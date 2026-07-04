# AndroidMasterTemplate Dependencies

This file contains the official dependency reference for all Bright libraries published from the AndroidMasterTemplate repository.

Always use the latest stable version unless a project requires a specific version.

---

# Repository

Add JitPack repository in your root settings.gradle.kts

```kotlin
dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {

        google()

        mavenCentral()

        maven(url = "https://jitpack.io")

    }

}
```

---

# Bright Core

Purpose

Provides common reusable utilities shared by all Bright libraries.

Dependency

```kotlin
implementation("com.github.SALM872.AndroidMasterTemplate:bright-core:bright-core-v1.0.0")
```

Use When

- Result Wrapper
- Common Utilities
- Logger
- Shared Helper Classes

Status

Stable

---

# Bright Room

Purpose

Reusable wrapper around Android Room.

Dependency

```kotlin
implementation("com.github.SALM872.AndroidMasterTemplate:bright-room:bright-room-v1.0.0")
```

Use When

- Local Database
- CRUD Operations
- Repository Pattern
- DAO
- Offline Storage

Status

Stable

---

# Bright Permission

Purpose

Modern Android Runtime Permission Library.

Dependency

```kotlin
implementation("com.github.SALM872.AndroidMasterTemplate:bright-permission:bright-permission-v1.0.0")
```

Use When

- Camera Permission
- Microphone Permission
- Storage Permission
- Notification Permission
- Location Permission
- Multiple Permissions
- Open App Settings
- Permanently Denied Detection

Status

Stable

---

# Upcoming Libraries

Bright Network

Status

Planned

---

Bright Storage

Status

Planned

---

Bright Camera

Status

Planned

---

Bright Firebase

Status

Planned

---

Bright Image Picker

Status

Planned

---

# Version Policy

Stable releases should always be preferred.

Example

1.0.0

1.0.1

1.1.0

2.0.0

---

# Release Source

GitHub

https://github.com/SALM872/AndroidMasterTemplate

JitPack

https://jitpack.io/#SALM872/AndroidMasterTemplate