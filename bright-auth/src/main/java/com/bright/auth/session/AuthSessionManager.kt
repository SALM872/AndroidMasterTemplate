package com.bright.auth.session

import com.bright.auth.model.AuthUser

internal object AuthSessionManager {

    private var currentUser: AuthUser? = null

    fun saveUser(user: AuthUser) {
        currentUser = user
    }

    fun getUser(): AuthUser? {
        return currentUser
    }

    fun clear() {
        currentUser = null
    }

    fun isLoggedIn(): Boolean {
        return currentUser != null
    }

}