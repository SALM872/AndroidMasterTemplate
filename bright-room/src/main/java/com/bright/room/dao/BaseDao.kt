package com.bright.room.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<T>)

    @Update
    suspend fun update(item: T)

    @Update
    suspend fun update(items: List<T>)

    @Delete
    suspend fun delete(item: T)

    @Delete
    suspend fun delete(items: List<T>)
}