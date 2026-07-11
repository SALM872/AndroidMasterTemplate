# Factory Context

Version: 1.0

---

# Overview

This repository is part of a larger Android development ecosystem called the Android Master Template Factory.

The factory is a continuously evolving collection of reusable Android libraries designed to eliminate repetitive development work and provide production-ready building blocks for future applications.

Each library in the factory is developed independently but follows the same architectural principles, coding standards, documentation style, and release process.

---

# Factory Goal

The primary objective of the Android Master Template Factory is to build a complete ecosystem of reusable Android libraries.

Instead of rewriting common functionality for every project, reusable libraries are created once, thoroughly tested, documented, and published.

These libraries become permanent building blocks that can be reused across unlimited Android applications.

Examples include:

- Authentication
- Storage
- Permissions
- Camera
- Networking
- Database
- Navigation
- Billing
- Analytics
- Notifications
- Logging
- Security
- File Management
- UI Components
- Utility Libraries

The long-term goal is to cover nearly every common requirement encountered in Android application development.

---

# Development Workflow

Every library follows the same lifecycle.

Step 1

Design the architecture.

↓

Step 2

Implement the library.

↓

Step 3

Create a dedicated sample application inside the library project.

↓

Step 4

Test every public API.

↓

Step 5

Complete documentation.

↓

Step 6

Push the repository to GitHub.

↓

Step 7

Publish using JitPack.

↓

Step 8

Verify the published dependency inside a separate Starter Template project.

↓

Step 9

After successful verification, return to the Android Master Template Factory and continue building new libraries.

This workflow ensures that every published library is tested both locally and as an external dependency.

---

# Android Master Template

The Android Master Template is the central development workspace.

It contains multiple library modules under active development.

Each module evolves independently while sharing a common architecture and coding philosophy.

The Master Template is not intended for direct production use.

Its purpose is rapid library development and internal testing.

---

# Starter Template

The Starter Template is a completely separate project.

Unlike the Master Template, it contains no local library modules.

Every library is imported using the published JitPack dependency.

This project verifies that published artifacts work correctly in a clean environment.

If a library works inside the Starter Template, it is considered ready for production use.

---

# Release Philosophy

Libraries are never considered complete immediately after development.

A library reaches production only after:

- Internal testing
- Sample application testing
- Documentation completion
- GitHub publication
- JitPack publication
- Starter Template verification

Only then is the release considered stable.

---

# Continuous Evolution

The Android Master Template Factory is a long-term project.

New libraries will continue to be added over time.

Existing libraries will continue receiving:

- Bug fixes
- Performance improvements
- Better APIs
- Better documentation
- Additional features

while maintaining backward compatibility whenever possible.

---

# Engineering Principles

Every library inside the factory should follow the same principles.

- Clean Architecture
- Single Responsibility Principle
- Reusable Components
- Stable Public APIs
- Minimal Boilerplate
- Consistent Naming
- Comprehensive Documentation
- Production Readiness
- Long-Term Maintainability

Consistency across libraries is considered more valuable than short-term convenience.

---

# AI Instructions

This repository is only one component of the Android Master Template Factory.

When making recommendations:

- Preserve architectural consistency across all libraries.
- Prefer reusable solutions over project-specific implementations.
- Avoid introducing patterns that conflict with existing factory standards.
- Keep documentation style consistent with other libraries.
- Consider how changes may affect future libraries within the factory.

Always treat the factory as a unified ecosystem rather than a collection of unrelated repositories.

---

# Long-Term Vision

The long-term vision of the Android Master Template Factory is to become a complete Android development platform consisting of high-quality reusable libraries.

Applications should eventually be built by combining these libraries rather than rewriting common functionality from scratch.

Every new library should strengthen the ecosystem and remain compatible with the overall factory architecture.