package com.example.budgettracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val username: String,
    val password: String
)
