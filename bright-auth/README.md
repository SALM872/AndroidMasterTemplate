# BrightAuth

<p align="center">

A lightweight, modular and production-ready Android Authentication SDK built with Kotlin.

Simple API • Clean Architecture • Provider Independent • Future Ready

</p>

---

## Overview

BrightAuth simplifies authentication in Android applications by providing a clean and stable API while hiding provider-specific implementation details.

The SDK is designed for modern Android development and follows a layered architecture that makes future authentication providers easy to integrate without changing the public API.

Current Provider

- ✅ Google Sign In

Planned Providers

- Facebook
- GitHub
- Apple
- Phone Authentication

---

# Features

- Google Sign In
- Google Sign Out
- Session Management
- Current User API
- Authentication State API
- Typed Error Handling
- Credential Manager Support
- Production Ready Architecture
- Kotlin First
- Jetpack Compose Friendly
- XML Project Compatible
- Minimal Public API

---

# Installation

## Step 1

Add JitPack.

```kotlin
dependencyResolutionManagement {

    repositories {

        google()

        mavenCentral()

        maven("https://jitpack.io")

    }

}
```

---

## Step 2

Add BrightAuth dependency.

```kotlin
implementation("com.github.YOUR_USERNAME:BrightAuth:v1.0.0")
```

---

# Quick Start

## Initialize

```kotlin
BrightAuth.initialize(

    activity = this,

    config = BrightAuthConfig(

        webClientId = "YOUR_WEB_CLIENT_ID"

    )

)
```

---

## Sign In

```kotlin
BrightAuth.signIn { result ->

    when(result){

        is AuthResult.Success -> {

            val user = result.user

        }

        is AuthResult.Error -> {

        }

        is AuthResult.Cancelled -> {

        }

    }

}
```

---

## Current User

```kotlin
val user = BrightAuth.currentUser()
```

---

## Authentication State

```kotlin
val loggedIn = BrightAuth.isSignedIn()
```

---

## Sign Out

```kotlin
BrightAuth.signOut()
```

---

# Public API

BrightAuth intentionally exposes only a small public API.

```kotlin
BrightAuth.initialize()

BrightAuth.signIn()

BrightAuth.signOut()

BrightAuth.currentUser()

BrightAuth.isSignedIn()
```

---

# Project Structure

```
bright-auth/

bright-core/

sample-bright-auth/

docs/
```

---

# Documentation

Detailed documentation is available inside the **docs** directory.

- Blueprint
- API Reference
- Setup Guide
- Architecture
- Roadmap
- AI Context

---

# Design Goals

BrightAuth follows these principles.

- Simple API
- Provider Isolation
- Stable Public Interface
- Internal Implementation Hiding
- Modular Architecture
- No UI Components
- Future Provider Expansion

---

# Current Status

Version

```
v1.0.0
```

Status

```
Production Ready
```

Supported Provider

```
Google Sign In
```

---

# Roadmap

Upcoming versions will introduce

- Facebook Authentication
- GitHub Authentication
- Apple Authentication
- Multi Provider Support
- Plugin Based Architecture

without breaking the existing public API.

---

# Contributing

Contributions are welcome.

Before contributing please read

- docs/00_BLUEPRINT.md
- docs/04_ARCHITECTURE.md
- docs/AI_CONTEXT.md

to understand the project philosophy.

---

# License

This project is released under the MIT License.

---

# Author

Developed by Salman Farsi.

BrightAuth is part of the Bright Android SDK ecosystem.