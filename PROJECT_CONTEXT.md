# AndroidMasterTemplate Context

This repository is a Library Factory.

It is NOT a normal Android application.

Purpose

Build reusable Android SDK modules.

Current Modules

- bright-core
- bright-room

Every module is first tested inside the app module.

After testing

GitHub

↓

JitPack

↓

Dependency

↓

Real Project

The app module exists only for testing libraries.

Future libraries

- BrightImagePicker
- BrightPermission
- BrightNetwork
- BrightCamera
- BrightStorage
- BrightPDF

The repository will always remain the Factory.

A separate Starter Template is used for client projects.

Starter Template contains only

- app
- Gradle
- libs.versions.toml
- settings.gradle.kts

No source libraries exist inside Starter Template.

Libraries are always consumed through JitPack.

Workflow

Factory

↓

GitHub

↓

JitPack

↓

Starter Template

↓

Client Project

Rules

Never copy library source code into client projects.

Always consume published libraries.

Every library must have

README

CHANGELOG

LICENSE

Sample Test

JitPack Test

Only after these are successful the library is considered Production Ready.