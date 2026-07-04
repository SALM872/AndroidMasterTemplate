# BrightPermission Architecture

This document explains the internal architecture of the BrightPermission library.

It is intended for contributors and future maintainers.

---

# Architecture Overview

Application

↓

BrightPermission

↓

PermissionManager

↓

PermissionEngine

↓

PermissionLauncher

↓

Android Activity Result API

↓

Android Permission System

---

# Module Structure

bright-permission/

│

├── api/

│     └── BrightPermission

│

├── manager/

│     └── PermissionManager

│

├── internal/

│     ├── PermissionEngine

│     ├── MultiplePermissionEngine

│     ├── PermissionValidator

│     ├── PermissionStateResolver

│     └── SettingsHelper

│

├── launcher/

│     └── PermissionLauncher

│

└── model/

      ├── PermissionType

      ├── PermissionState

      ├── PermissionResult

      └── PermissionResults

---

# Package Responsibilities

## api

Contains only public APIs.

Developers should interact only with this package.

Example

BrightPermission.request()

---

## manager

Acts as a routing layer.

It forwards public API calls to the appropriate internal engine.

No business logic should exist here.

---

## internal

Contains the complete business logic.

Responsibilities

- Permission checking
- Request handling
- State resolution
- Validation
- Settings navigation

This package is not intended for public use.

---

## launcher

Wraps the Android Activity Result API.

Responsibilities

- Single Permission Launcher
- Multiple Permission Launcher

No business logic should exist here.

---

## model

Contains reusable data models shared across the library.

Examples

PermissionResult

PermissionResults

PermissionState

PermissionType

---

# Permission Request Flow

Single Permission

User

↓

BrightPermission.request()

↓

PermissionManager

↓

PermissionEngine

↓

PermissionLauncher

↓

Android Permission Dialog

↓

PermissionStateResolver

↓

PermissionResult

↓

Developer Callback

---

# Multiple Permission Flow

User

↓

BrightPermission.request(...)

↓

PermissionManager

↓

MultiplePermissionEngine

↓

PermissionLauncher

↓

Android Permission Dialog

↓

PermissionStateResolver

↓

PermissionResults

↓

Developer Callback

---

# Validation Flow

Request

↓

PermissionValidator

↓

Already Granted?

↓

Yes

↓

Return Result

↓

No

↓

Launch Permission Dialog

---

# Permanent Denied Flow

Permission Requested

↓

User selects

Don't Allow

↓

PermissionStateResolver

↓

PERMANENTLY_DENIED

↓

Developer decides

↓

BrightPermission.openSettings()

↓

Application Settings

---

# Design Principles

The architecture follows these principles:

- Single Responsibility Principle
- Separation of Concerns
- Reusable Components
- Minimal Public API
- Internal Implementation Hidden
- Easy to Extend
- Easy to Maintain

---

# Current Architecture Version

v1.0.0

Status

Stable

---

# Future Improvements

- Sequential Permission Engine
- Permission Groups
- Compose Integration
- Analytics Layer
- Permission History