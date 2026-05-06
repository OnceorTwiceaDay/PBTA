
package com.example.budgettracker
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Expense(
 @PrimaryKey(autoGenerate = true) val id:Int=0,
 val amount:Double,
 val description:String,
 val date:String,
 val startTime:String,
 val endTime:String,
 val category:String,
 val imageUri:String?,
 val username: String
)
