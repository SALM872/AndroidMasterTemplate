# BrightAuth AI Context

## Purpose

This document provides complete context about the BrightAuth SDK.

It is intended for AI assistants, future maintainers, contributors, and developers who need to understand the project without reading every source file.

This document represents the project's design philosophy, architecture, API contract, coding standards, implementation decisions, and future direction.

---

# Project Overview

Project Name

BrightAuth

Language

Kotlin

Platform

Android

Architecture

Layered Architecture

Status

Production Ready (v1.0.0)

Current Authentication Provider

Google Sign In

Future Providers

Facebook

GitHub

Apple

Phone Authentication

---

# Vision

BrightAuth is designed to become a lightweight, modular, provider-independent Android Authentication SDK.

The primary goal is to hide provider-specific implementation details while exposing a very small and stable public API.

The SDK should remain simple for application developers while allowing internal implementation to evolve independently.

---

# Public API Philosophy

Only one public entry point exists.

BrightAuth

The developer should never access internal packages directly.

The ideal developer experience is

Initialize

↓

Sign In

↓

Receive Result

↓

Access Current User

↓

Sign Out

Nothing more.

---

# Current Public API

BrightAuth.initialize()

BrightAuth.signIn()

BrightAuth.signOut()

BrightAuth.currentUser()

BrightAuth.isSignedIn()

No additional public API should be added unless it significantly improves developer experience.

---

# Internal Architecture

Application

↓

BrightAuth

↓

AuthManager

↓

AuthEngine

↓

Provider Engine

↓

Provider Client

↓

Credential Manager

↓

Authentication Provider

---

# Internal Components

BrightAuth

Public API

---

AuthManager

Coordinates SDK operations.

---

AuthEngine

Common authentication interface.

Every authentication provider must implement this interface.

---

GoogleAuthEngine

Google authentication implementation.

---

GoogleAuthClient

Communicates with CredentialManager.

---

GoogleAuthParser

Converts Google credentials into AuthUser.

---

GoogleAuthExceptionMapper

Maps provider exceptions into BrightAuth exceptions.

---

AuthSessionManager

Stores the authenticated user.

Provides

currentUser()

isLoggedIn()

clear()

---

BrightInitializer

Stores SDK configuration.

---

# Session Model

Current implementation

Memory only.

Persistent storage is intentionally excluded from Version 1.0.

Future versions may introduce DataStore support without changing the public API.

---

# Error Handling

Provider exceptions must never be exposed directly.

Instead

Provider Exception

↓

GoogleAuthExceptionMapper

↓

AuthException

↓

AuthResult.Error

Applications should only depend on AuthException.

---

# Authentication Result

Authentication always returns AuthResult.

Possible states

Success

Error

Cancelled

No provider-specific result should ever escape the SDK.

---

# UI Philosophy

BrightAuth intentionally does not provide UI components.

The SDK will never include

Loading Dialogs

Buttons

Login Screens

Navigation

Snackbars

Toasts

Animations

UI remains the responsibility of the host application.

This decision keeps BrightAuth independent of Compose, XML, Material versions, and application-specific design systems.

---

# Provider Philosophy

Every provider should implement the same architecture.

Example

Google

↓

GoogleAuthEngine

↓

GoogleAuthClient

↓

Parser

↓

Session

↓

Result

Future providers should follow exactly the same pattern.

No provider should require changes to the BrightAuth public API.

---

# Coding Rules

Public APIs should remain stable.

Internal classes should remain internal.

Business logic must remain outside UI.

Avoid duplicate state.

Session should have a single source of truth.

Provider implementations must remain isolated.

Authentication providers should never leak provider-specific classes.

---

# Future Direction

Version 1.1

Facebook Authentication

Version 1.2

GitHub Authentication

Version 1.3

Apple Authentication

Version 2.0

Plugin based authentication providers.

Custom provider support.

Enterprise features.

---

# Development Guidelines

When modifying BrightAuth

Always preserve backward compatibility.

Avoid breaking the public API.

Prefer composition over duplication.

Keep provider implementations independent.

Maintain a clear separation between public API and internal implementation.

Do not introduce UI into the SDK.

Keep architecture modular.

---

# Documentation Policy

Every public API change must update

README

API_REFERENCE

BLUEPRINT

AI_CONTEXT

Roadmap

This ensures documentation never falls behind implementation.

---

# Project Identity

BrightAuth is not just a Google Sign-In wrapper.

BrightAuth is the authentication foundation of the Bright SDK ecosystem.

It is designed to become a complete authentication platform for Android while maintaining a clean, stable, and developer-friendly API.