# Android SDK Design Guidelines v1.0

## 1. Purpose

AndroidMasterTemplate is the single source of truth for all Android apps and reusable libraries.

Every new App or Library must be created from this template.

---

# 2. Technology Rules

- Kotlin Only
- Jetpack Compose Only
- Material 3 Only
- Kotlin DSL Only
- Version Catalog Only
- Java 17
- KSP Preferred
- No XML (unless absolutely required)

---

# 3. Dependency Rules

Never update a dependency just because a newer version exists.

Update only after verifying:

- AGP Compatibility
- Gradle Compatibility
- Kotlin Compatibility
- Compose Compatibility
- AndroidX Compatibility

---

# 4. Package Structure

core/
common/
data/
domain/
navigation/
utils/
ui/
components/
screens/
theme/

---

# 5. Library Structure

builder/
core/
extensions/
internal/
model/
ui/
utils/

---

# 6. Public API Rules

Only expose necessary APIs.

Hide implementation inside internal package.

---

# 7. Builder Pattern

Every configurable SDK must provide a Builder.

Example:

RoomKit.Builder()

GoogleLogin.Builder()

CameraKit.Builder()

---

# 8. Versioning

Major.Minor.Patch

Example

1.0.0

1.1.0

1.1.1

---

# 9. Publishing

Every library must support

- GitHub
- JitPack
- Maven Publish

---

# 10. Quality Checklist

Before release:

✔ Build Successful

✔ Sample App Tested

✔ JitPack Build Passed

✔ Documentation Updated

✔ CHANGELOG Updated

✔ Version Increased

---

# 11. Stable Rule

AndroidMasterTemplate is the platform.

Libraries must follow the template.

Applications must follow the template.

Never the opposite.