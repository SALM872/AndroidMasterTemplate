package com.example.template.data.repository

import com.bright.room.repository.BaseRepository
import com.example.template.data.dao.UserDao
import com.example.template.data.entity.User
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val dao: UserDao
) : BaseRepository<User>(dao) {

    fun getAllUsers(): Flow<List<User>> =
        dao.getAllUsers()
}