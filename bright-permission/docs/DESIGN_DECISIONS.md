# BrightPermission Design Decisions

This document records the major architectural and design decisions taken during the development of BrightPermission.

Its purpose is to help future maintainers understand *why* the library is designed this way.

---

# Decision 1

## Keep the Public API Small

Decision

Expose only a few public methods.

Public APIs

- initialize()
- request(permission)
- request(vararg permissions)
- hasPermission()
- openSettings()

Reason

A small API is easier to learn, maintain and document.

---

# Decision 2

## Hide Internal Implementation

Decision

All implementation details remain inside the internal package.

Reason

Developers should never depend on internal classes.

This allows the internal architecture to evolve without breaking existing applications.

---

# Decision 3

## Separate Public API from Business Logic

Decision

BrightPermission only exposes APIs.

PermissionManager routes requests.

PermissionEngine performs business logic.

Reason

Each layer has a single responsibility.

---

# Decision 4

## Separate Validation Logic

Decision

Create PermissionValidator.

Responsibilities

- Initialization validation
- Permission validation
- Duplicate permission removal

Reason

Avoid duplicated validation logic across multiple engines.

---

# Decision 5

## Separate Permission State Resolution

Decision

Create PermissionStateResolver.

Reason

Permission state detection should exist in only one place.

Benefits

- Easier maintenance
- Consistent behavior
- Single source of truth

---

# Decision 6

## Support Both Single and Multiple Permission Requests

Decision

Provide overloaded request() APIs.

Examples

Single

BrightPermission.request(...)

Multiple

BrightPermission.request(...)

Reason

Simple API while supporting multiple use cases.

---

# Decision 7

## Wrap Android Activity Result API

Decision

Create PermissionLauncher.

Reason

Developers should never interact directly with ActivityResultContracts.

The library hides Android-specific implementation details.

---

# Decision 8

## Keep the Library Lightweight

Decision

No external dependencies.

Reason

Smaller APK size.

Faster integration.

Lower maintenance.

---

# Decision 9

## Documentation First

Decision

Every Bright SDK module must contain complete documentation.

Required files

- README.md
- CHANGELOG.md
- ROADMAP.md
- API_REFERENCE.md
- ARCHITECTURE.md
- DESIGN_DECISIONS.md

Reason

Future maintenance should not depend on memory or old chat history.

---

# Decision 10

## Factory Rule

Decision

Avoid over-engineering.

Maximum architecture clarity with minimum complexity.

Reason

Readable code is more valuable than clever code.

The goal is to help developers understand the library quickly.

---

# Future Decisions

Any major architectural decision should be added to this document.

Do not overwrite previous decisions.

Append new ones while preserving history.

---

# Current Version

v1.0.0

Status

Stable