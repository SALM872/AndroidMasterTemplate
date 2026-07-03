package com.example.template.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bright.room.builder.BrightRoom
import com.example.template.data.database.AppDatabase
import com.example.template.data.entity.User
import com.example.template.data.repository.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val database = BrightRoom.database<AppDatabase>()

    private val repository = UserRepository(database.userDao())

    val users: StateFlow<List<User>> =
        repository
            .getAllUsers()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun insertUser(
        name: String,
        age: Int
    ) {

        if (name.isBlank()) return

        viewModelScope.launch {

            repository.insert(
                User(
                    name = name,
                    age = age
                )
            )

        }
    }

    fun updateUser(user: User) {

        viewModelScope.launch {

            repository.update(user)

        }
    }

    fun deleteUser(user: User) {

        viewModelScope.launch {

            repository.delete(user)

        }
    }
}