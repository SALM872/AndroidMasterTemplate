# BrightAuth API Reference

## Overview

This document describes every public API exposed by BrightAuth.

Only the BrightAuth object should be accessed by application developers.

Internal classes are not part of the public API and should never be used directly.

---

# BrightAuth.initialize()

Initializes the BrightAuth SDK.

This method must be called before using any authentication feature.

## Parameters

| Name | Type | Required |
|------|------|----------|
| activity | ComponentActivity | Yes |
| config | BrightAuthConfig | Yes |

## Example

```kotlin
BrightAuth.initialize(
    activity = this,
    config = BrightAuthConfig(
        webClientId = "YOUR_WEB_CLIENT_ID"
    )
)
```

---

# BrightAuth.signIn()

Starts the authentication flow.

Depending on the configured provider, BrightAuth launches the appropriate authentication screen.

Current Provider

- Google Sign In

## Parameters

| Name | Type |
|------|------|
| callback | AuthCallback |

## Example

```kotlin
BrightAuth.signIn { result ->

    when(result){

        is AuthResult.Success -> {

        }

        is AuthResult.Error -> {

        }

    }

}
```

---

# BrightAuth.signOut()

Signs out the currently authenticated user.

This method performs:

- Clear session
- Clear current user
- Reset authentication state

## Example

```kotlin
BrightAuth.signOut()
```

---

# BrightAuth.isSignedIn()

Returns whether a user is currently authenticated.

## Return

```kotlin
Boolean
```

## Example

```kotlin
if(BrightAuth.isSignedIn()){

}
```

---

# BrightAuth.currentUser()

Returns the currently authenticated user.

Returns null if no active session exists.

## Return

```kotlin
AuthUser?
```

## Example

```kotlin
val user = BrightAuth.currentUser()
```

---

# AuthUser

Represents an authenticated user.

## Properties

| Property | Type |
|----------|------|
| id | String |
| name | String |
| email | String |
| photoUrl | String? |
| idToken | String |
| provider | AuthProvider |

---

# AuthResult.Success

Returned after successful authentication.

Contains:

- AuthUser

---

# AuthResult.Error

Returned when authentication fails.

Contains:

- AuthException

---

# AuthException

Possible authentication errors include:

- UserCancelled
- NoCredentialAvailable
- NetworkError
- InvalidConfiguration
- Unknown

Applications should always handle AuthResult.Error.

---

# Public API Summary

BrightAuth exposes only five primary methods.

- initialize()
- signIn()
- signOut()
- currentUser()
- isSignedIn()

No internal classes should be accessed directly.

---

# API Stability

The public API is designed to remain stable across future versions.

New authentication providers will be added without changing the existing API.