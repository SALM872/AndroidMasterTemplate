# Changelog

All notable changes to this project will be documented in this file.

The format follows Keep a Changelog principles.

Versioning follows Semantic Versioning (SemVer).

---

# [1.0.0] - Initial Release

## Added

### Core

- Initial BrightAuth SDK
- Modular project architecture
- BrightAuth public API
- BrightInitializer
- AuthManager
- AuthEngine abstraction

---

### Google Authentication

- Google Sign In
- Google Sign Out
- Credential Manager integration
- Google Authentication Parser
- Google Exception Mapper

---

### Session

- AuthSessionManager
- Current User API
- Authentication State API

---

### Error Handling

- AuthResult
- AuthException
- Exception Mapping
- Cancelled Authentication State

---

### Public API

- BrightAuth.initialize()
- BrightAuth.signIn()
- BrightAuth.signOut()
- BrightAuth.currentUser()
- BrightAuth.isSignedIn()

---

### Sample

- Sample BrightAuth application
- Google Authentication testing
- Session verification
- Logout verification

---

### Documentation

- README
- Blueprint
- API Reference
- Setup Guide
- Architecture Guide
- Roadmap
- AI Context

---

## Changed

Initial production-ready SDK architecture.

---

## Fixed

- Session clearing during logout.
- Exception mapping.
- Authentication state handling.
- Public API cleanup.
- Internal architecture improvements.

---

## Removed

- Unused APIs.
- Dead code.
- Experimental public methods.