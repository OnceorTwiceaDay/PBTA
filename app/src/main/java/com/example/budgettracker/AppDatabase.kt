
package com.example.budgettracker
import android.content.Context
import androidx.room.*

@Database(entities=[Expense::class,Category::class,Goal::class,User::class,Income::class],version=5)
abstract class AppDatabase:RoomDatabase(){
 abstract fun dao():AppDao
 companion object{
  private var INSTANCE:AppDatabase?=null
  fun getDB(ctx:Context):AppDatabase{
   if(INSTANCE==null){
    INSTANCE=Room.databaseBuilder(ctx,AppDatabase::class.java,"db").fallbackToDestructiveMigration().build()
   }
   return INSTANCE!!
  }
 }
}
