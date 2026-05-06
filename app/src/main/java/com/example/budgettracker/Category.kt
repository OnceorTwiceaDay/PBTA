
package com.example.budgettracker
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
 @PrimaryKey(autoGenerate = true) val id:Int=0,
 val name:String,
 val username: String? = null // null means it's a default/system category or migration
)
