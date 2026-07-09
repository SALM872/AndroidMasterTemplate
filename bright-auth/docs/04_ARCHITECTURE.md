# BrightAuth Architecture

## Overview

BrightAuth follows a layered architecture that separates the public API from provider-specific implementations.

The application interacts only with the BrightAuth API. All authentication logic, provider integrations, session handling, and error mapping remain internal.

---

# High Level Architecture

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

# Package Structure

api/

Public SDK entry point.

Contains the BrightAuth object.

---

builder/

Responsible for SDK configuration.

Contains initialization logic and configuration models.

---

callback/

Contains callback interfaces exposed by the SDK.

---

core/

Contains shared abstractions used across providers.

Examples

- AuthEngine
- Initializer

---

exceptions/

Defines authentication exceptions returned to developers.

The SDK never exposes provider-specific exceptions directly.

---

google/

Contains the complete Google authentication implementation.

Includes

- GoogleAuthEngine
- GoogleAuthClient
- GoogleAuthParser
- GoogleAuthExceptionMapper

---

manager/

Coordinates SDK operations.

Acts as the central controller between the public API and provider implementations.

---

model/

Contains public data models.

Examples

- AuthUser
- AuthResult
- AuthProvider

---

session/

Responsible for authentication session management.

Stores the authenticated user and clears the session during sign out.

---

# Authentication Flow

Application

↓

BrightAuth.signIn()

↓

AuthManager

↓

GoogleAuthEngine

↓

GoogleAuthClient

↓

CredentialManager

↓

Google Account Picker

↓

Google Authentication

↓

GoogleAuthParser

↓

AuthSessionManager

↓

AuthResult.Success

---

# Session Flow

Successful Login

↓

Create AuthUser

↓

Save Session

↓

currentUser()

↓

isSignedIn()

↓

signOut()

↓

Clear Session

---

# Error Flow

CredentialManager

↓

GetCredentialException

↓

GoogleAuthExceptionMapper

↓

AuthException

↓

AuthResult.Error

↓

Application

---

# Design Principles

The architecture follows these principles.

- Single Responsibility Principle
- Modular Design
- Provider Isolation
- Internal Implementation Hiding
- Stable Public API
- Easy Future Expansion

---

# Provider Architecture

Every authentication provider must implement AuthEngine.

Example

Google

↓

GoogleAuthEngine

↓

GoogleAuthClient

↓

Google Authentication

Future providers will follow the same architecture.

Facebook

↓

FacebookAuthEngine

GitHub

↓

GithubAuthEngine

Apple

↓

AppleAuthEngine

No public API changes will be required.

---

# Session Management

The SDK stores only the authenticated user's session.

Session responsibilities include

- Save authenticated user
- Return current user
- Clear session during sign out

Persistent storage is intentionally not included in v1.0.

---

# Public API Boundary

Application developers should only access

- BrightAuth

Everything else is considered an internal implementation detail.

---

# Future Architecture

The architecture is designed to support multiple authentication providers without breaking existing applications.

New providers will integrate by implementing the AuthEngine interface while preserving the same public API.

This approach ensures long-term API stability and simplifies future SDK evolution.