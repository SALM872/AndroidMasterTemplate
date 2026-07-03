package com.bright.room.repository

object RepositoryProvider {

    private val repositories = mutableMapOf<Class<*>, Any>()

    fun <T : Any> register(
        clazz: Class<T>,
        repository: T
    ) {
        repositories[clazz] = repository
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> get(clazz: Class<T>): T {
        return repositories[clazz] as T
    }
}