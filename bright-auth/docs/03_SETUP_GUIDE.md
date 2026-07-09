# BrightAuth Setup Guide

## Overview

This guide explains how to integrate BrightAuth into an Android application.

Current Supported Provider

- Google Sign In

---

# Requirements

- Android Studio
- Kotlin
- Android SDK
- Firebase Project
- Google Play Services

---

# Step 1

Create a Firebase Project.

---

# Step 2

Add an Android App to Firebase.

Package name example

```
com.example.app
```

Package name must exactly match the Android application's package name.

---

# Step 3

Add SHA-1 fingerprint.

Example

```
18:F5:39:6A:8C:74:1A:CB:C7:A6:B6:0F:03:E4:6A:C6:37:2B:F7:FF
```

---

# Step 4

Enable Google Authentication.

Firebase Console

Authentication

↓

Sign-in Method

↓

Enable Google

---

# Step 5

Download

google-services.json

Place the file inside the Android application's module.

Example

```
app/
    google-services.json
```

For the BrightAuth sample project

```
sample-bright-auth/
    google-services.json
```

---

# Step 6

Copy the Web Client ID.

Firebase Console

↓

Project Settings

↓

General

↓

Web Client ID

Example

```
xxxxxxxxxxxxxxxx.apps.googleusercontent.com
```

---

# Step 7

Initialize BrightAuth.

Example

```kotlin
BrightAuth.initialize(

    activity = this,

    config = BrightAuthConfig(

        webClientId = "YOUR_WEB_CLIENT_ID"

    )

)
```

Initialization should be performed once before calling signIn().

---

# Step 8

Start Login.

```kotlin
BrightAuth.signIn { result ->

}
```

---

# Step 9

Get Current User.

```kotlin
val user = BrightAuth.currentUser()
```

---

# Step 10

Logout.

```kotlin
BrightAuth.signOut()
```

---

# Common Errors

## App crashes before login

Cause

BrightAuth.initialize() was not called.

---

## Google dialog does not appear

Possible reasons

- Invalid Web Client ID
- Incorrect package name
- Missing SHA-1
- Google Authentication disabled
- Missing google-services.json

---

## No credentials available

Cause

User cancelled authentication or no eligible Google account was found.

---

# Best Practices

- Initialize BrightAuth only once.
- Always handle AuthResult.Error.
- Never expose the ID Token.
- Never modify internal BrightAuth classes.
- Keep google-services.json inside the application module.

---

# Support

If setup is completed correctly, BrightAuth should authenticate the user with only three steps.

1. Initialize

2. Sign In

3. Handle Result