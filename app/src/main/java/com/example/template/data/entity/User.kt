package com.example.template.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bright.room.entity.BaseEntity

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,

    val name: String,

    val age: Int

) : BaseEntity<Long>