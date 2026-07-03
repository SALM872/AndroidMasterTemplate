package com.bright.room.migration

import androidx.room.migration.Migration

object MigrationRegistry {

    private val migrations = mutableListOf<Migration>()

    fun register(vararg migration: Migration) {
        migrations.addAll(migration)
    }

    fun getAll(): Array<Migration> {
        return migrations.toTypedArray()
    }

    fun clear() {
        migrations.clear()
    }
}