package com.bright.room.repository

import com.bright.core.result.Result
import com.bright.room.dao.BaseDao

abstract class BaseRepository<T>(
    private val dao: BaseDao<T>
) {

    suspend fun insert(item: T): Result<Unit> =
        runCatching {
            dao.insert(item)
            Result.Success(Unit)
        }.getOrElse {
            Result.Error(it.message ?: "Insert Failed")
        }

    suspend fun insert(items: List<T>): Result<Unit> =
        runCatching {
            dao.insert(items)
            Result.Success(Unit)
        }.getOrElse {
            Result.Error(it.message ?: "Bulk Insert Failed")
        }

    suspend fun update(item: T): Result<Unit> =
        runCatching {
            dao.update(item)
            Result.Success(Unit)
        }.getOrElse {
            Result.Error(it.message ?: "Update Failed")
        }

    suspend fun update(items: List<T>): Result<Unit> =
        runCatching {
            dao.update(items)
            Result.Success(Unit)
        }.getOrElse {
            Result.Error(it.message ?: "Bulk Update Failed")
        }

    suspend fun delete(item: T): Result<Unit> =
        runCatching {
            dao.delete(item)
            Result.Success(Unit)
        }.getOrElse {
            Result.Error(it.message ?: "Delete Failed")
        }

    suspend fun delete(items: List<T>): Result<Unit> =
        runCatching {
            dao.delete(items)
            Result.Success(Unit)
        }.getOrElse {
            Result.Error(it.message ?: "Bulk Delete Failed")
        }
}