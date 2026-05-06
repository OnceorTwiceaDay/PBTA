package com.example.budgettracker

data class TransactionItem(
    val id: Int,
    val amount: Double,
    val description: String,
    val date: String,
    val isExpense: Boolean,
    val category: String = "",
    val hasPhoto: Boolean = false
)
