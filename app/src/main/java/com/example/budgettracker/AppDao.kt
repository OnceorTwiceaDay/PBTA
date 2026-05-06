package com.example.budgettracker
import androidx.room.*

@Dao
interface AppDao {
    @Insert suspend fun insertExpense(e: Expense)
    @Insert suspend fun insertCategory(c: Category)
    @Update suspend fun updateExpense(e: Expense)
    @Delete suspend fun deleteExpense(e: Expense)

    @Query("SELECT * FROM Expense WHERE username = :username ORDER BY date DESC, startTime DESC")
    suspend fun getExpenses(username: String): List<Expense>

    @Query("SELECT * FROM Category WHERE username IS NULL OR username = :username")
    suspend fun getCategories(username: String): List<Category>

    @Query("SELECT * FROM Expense WHERE id = :id")
    suspend fun getExpenseById(id: Int): Expense?

    @Query("SELECT * FROM Expense WHERE username = :username AND date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    suspend fun getExpensesByDateRange(username: String, startDate: String, endDate: String): List<Expense>

    @Query("SELECT category as categoryName, SUM(amount) as totalAmount FROM Expense WHERE username = :username AND date BETWEEN :startDate AND :endDate GROUP BY category")
    suspend fun getCategoryTotals(username: String, startDate: String, endDate: String): List<CategoryTotal>

    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertGoal(g: Goal)
    @Query("SELECT * FROM Goal WHERE username = :username AND monthYear = :monthYear")
    suspend fun getGoal(username: String, monthYear: String): Goal?

    @Insert suspend fun insertUser(user: User)
    @Query("SELECT * FROM User WHERE username = :username") suspend fun getUser(username: String): User?
    @Delete suspend fun deleteUser(user: User)

    // Income methods
    @Insert suspend fun insertIncome(i: Income)
    @Query("SELECT * FROM Income WHERE username = :username ORDER BY date DESC, time DESC")
    suspend fun getIncomes(username: String): List<Income>
    @Query("SELECT SUM(amount) FROM Income WHERE username = :username")
    suspend fun getTotalIncome(username: String): Double?
    @Query("SELECT SUM(amount) FROM Expense WHERE username = :username")
    suspend fun getTotalExpense(username: String): Double?
    @Delete suspend fun deleteIncome(i: Income)
}

data class CategoryTotal(
    val categoryName: String,
    val totalAmount: Double
)
