package com.example.template.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.bright.room.dao.BaseDao
import com.example.template.data.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllUsers(): Flow<List<User>>
}