package com.example.budgettracker

import androidx.room.Entity

@Entity(primaryKeys = ["monthYear", "username"])
data class Goal(
    val monthYear: String, // format "yyyy-MM"
    val username: String,
    val minGoal: Double,
    val maxGoal: Double
)
