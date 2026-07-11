# 🚀 Bright Android Factory

A collection of modern Android libraries built with **Kotlin**, **Jetpack Compose**, and **AndroidX** to speed up Android development.

The goal of this project is to provide production-ready, modular, reusable libraries that can be integrated into any Android application with minimal setup.

---

# ✨ Why Bright Android Factory?

Building the same features repeatedly wastes development time.

Bright Android Factory solves this by providing reusable libraries for common Android tasks.

Instead of writing everything from scratch, simply add the required module and start building your app.

---

# 📦 Available Libraries

| Library | Status | Description |
|---------|--------|-------------|
| Bright Core | ✅ Stable | Common utilities, shared classes and base components |
| Bright Auth | ✅ Stable | Authentication utilities and login helpers |
| Bright Room | ✅ Stable | Simplified Room Database architecture |
| Bright Permission | ✅ Stable | Runtime permission handling |
| Bright Storage | ✅ Stable | Image, Video, Audio, Document Picker & Camera APIs |

---

# 🚧 Planned Libraries

These libraries are planned for future releases.

- Bright Firebase
- Bright Network
- Bright Notification
- Bright Billing
- Bright Camera
- Bright Analytics
- Bright Location
- Bright Media
- Bright Payment
- Bright PDF
- Bright Downloader
- Bright Logger
- Bright Bluetooth
- Bright Maps
- Bright AI

---

# 📱 Features

- Kotlin First
- Jetpack Compose Ready
- AndroidX Compatible
- Lifecycle Aware
- Easy Integration
- Modular Architecture
- Production Ready APIs
- Beginner Friendly
- JitPack Distribution
- Open Source

---

# 📥 Installation

Add JitPack repository.

```gradle
dependencyResolutionManagement {

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

}
```

Then add the required library.

Example:

```gradle
implementation("com.github.SALM872.AndroidMasterTemplate:bright-storage:latest-version")
```

Replace **latest-version** with the latest release.

---

# 📚 Documentation

Each library contains its own documentation.

| Library | Documentation |
|----------|---------------|
| Bright Core | docs/ |
| Bright Auth | docs/ |
| Bright Room | docs/ |
| Bright Permission | docs/ |
| Bright Storage | docs/ |

Each documentation includes

- Installation
- Configuration
- API Reference
- Examples
- Best Practices

---

# 🏗 Project Structure

```
AndroidMasterTemplate

├── bright-core
├── bright-auth
├── bright-room
├── bright-permission
├── bright-storage
│
├── docs
├── samples
├── CHANGELOG.md
├── DEPENDENCIES.md
└── README.md
```

---

# 📌 Design Principles

Every Bright library follows the same philosophy.

- Simple API
- Clean Architecture
- Minimal Boilerplate
- Consistent Naming
- Reusable Components
- Easy Maintenance
- Production Ready

---

# 🤝 Contributing

Contributions, feature requests and bug reports are welcome.

If you find an issue, please open an Issue or submit a Pull Request.

---

# 📄 License

This project is released under the MIT License.

---

# ❤️ Developed By

**Salman (SALM872)**

Building reusable Android libraries for modern Android development.
