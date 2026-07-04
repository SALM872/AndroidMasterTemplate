# BrightPermission API Reference

This document describes all public APIs provided by the BrightPermission library.

Only public APIs are documented here.

Internal implementation classes are intentionally excluded.

---

# BrightPermission

Main entry point of the library.

Import

```kotlin
import com.bright.permission.api.BrightPermission
```

---

# initialize()

Registers the internal Activity Result Launchers.

This function must be called once before requesting any permission.

## Syntax

```kotlin
BrightPermission.initialize(activity)
```

## Parameters

| Name | Type | Required |
|------|------|----------|
| activity | ComponentActivity | Yes |

## Returns

None

## Example

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)

    BrightPermission.initialize(this)

}
```

---

# request()

Requests a single runtime permission.

## Syntax

```kotlin
BrightPermission.request(
    PermissionType.CAMERA
) { result ->

}
```

## Parameters

| Name | Type |
|------|------|
| permission | PermissionType |

## Callback

Returns

```kotlin
PermissionResult
```

## Possible States

- GRANTED
- DENIED
- PERMANENTLY_DENIED

---

# request(vararg)

Requests multiple runtime permissions.

## Syntax

```kotlin
BrightPermission.request(

    PermissionType.CAMERA,

    PermissionType.MICROPHONE,

    PermissionType.STORAGE

) { results ->

}
```

## Parameters

| Name | Type |
|------|------|
| permissions | PermissionType |

## Callback

Returns

```kotlin
PermissionResults
```

Each permission has its own PermissionResult.

---

# hasPermission()

Checks whether a permission is already granted.

## Syntax

```kotlin
val granted = BrightPermission.hasPermission(

    context,

    PermissionType.CAMERA

)
```

## Returns

```kotlin
Boolean
```

---

# openSettings()

Opens the application's Settings screen.

Useful when a permission has been permanently denied.

## Syntax

```kotlin
BrightPermission.openSettings(context)
```

## Returns

None

---

# PermissionType

Represents supported runtime permissions.

Example

```kotlin
PermissionType.CAMERA

PermissionType.MICROPHONE

PermissionType.STORAGE
```

Future versions may include additional permission types.

---

# PermissionState

Represents the current permission status.

Possible values

```text
GRANTED

DENIED

PERMANENTLY_DENIED
```

---

# PermissionResult

Represents the result of a single permission request.

Properties

| Property | Type |
|----------|------|
| permission | PermissionType |
| state | PermissionState |

---

# PermissionResults

Represents the result of multiple permission requests.

Contains

```kotlin
Map<PermissionType, PermissionResult>
```

---

# Error Handling

The library throws an exception when

```kotlin
BrightPermission.initialize()
```

has not been called before requesting permissions.

---

# Thread Safety

All public APIs are intended to be called from the Main Thread.

---

# Best Practices

- Call initialize() only once.
- Request permissions only when needed.
- Show proper rationale before requesting permissions.
- Redirect permanently denied users to App Settings.

---

# Since

Version

v1.0.0