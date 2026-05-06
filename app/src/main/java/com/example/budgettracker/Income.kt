package com.example.budgettracker

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Income(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val amount: Double,
    val description: String,
    val date: String,
    val time: String,
    val username: String
)
