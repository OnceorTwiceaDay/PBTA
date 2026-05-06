package com.example.budgettracker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0019J \u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010#J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010\'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0018\u0010(\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020!H\u00a7@\u00a2\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u00101\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u00063"}, d2 = {"Lcom/example/budgettracker/AppDao;", "", "deleteExpense", "", "e", "Lcom/example/budgettracker/Expense;", "(Lcom/example/budgettracker/Expense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteIncome", "i", "Lcom/example/budgettracker/Income;", "(Lcom/example/budgettracker/Income;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "user", "Lcom/example/budgettracker/User;", "(Lcom/example/budgettracker/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "", "Lcom/example/budgettracker/Category;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategoryTotals", "Lcom/example/budgettracker/CategoryTotal;", "startDate", "endDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExpenseById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExpenses", "getExpensesByDateRange", "getGoal", "Lcom/example/budgettracker/Goal;", "monthYear", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncomes", "getTotalExpense", "", "getTotalIncome", "getUser", "insertCategory", "c", "(Lcom/example/budgettracker/Category;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExpense", "insertGoal", "g", "(Lcom/example/budgettracker/Goal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertIncome", "insertUser", "updateExpense", "app_debug"})
@androidx.room.Dao()
public abstract interface AppDao {
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertExpense(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.Expense e, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCategory(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.Category c, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateExpense(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.Expense e, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteExpense(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.Expense e, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Expense WHERE username = :username ORDER BY date DESC, startTime DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getExpenses(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.budgettracker.Expense>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Category WHERE username IS NULL OR username = :username")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.budgettracker.Category>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Expense WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getExpenseById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.budgettracker.Expense> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Expense WHERE username = :username AND date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getExpensesByDateRange(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.budgettracker.Expense>> $completion);
    
    @androidx.room.Query(value = "SELECT category as categoryName, SUM(amount) as totalAmount FROM Expense WHERE username = :username AND date BETWEEN :startDate AND :endDate GROUP BY category")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCategoryTotals(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String startDate, @org.jetbrains.annotations.NotNull()
    java.lang.String endDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.budgettracker.CategoryTotal>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertGoal(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.Goal g, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Goal WHERE username = :username AND monthYear = :monthYear")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoal(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String monthYear, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.budgettracker.Goal> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM User WHERE username = :username")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.budgettracker.User> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertIncome(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.Income i, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Income WHERE username = :username ORDER BY date DESC, time DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getIncomes(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.budgettracker.Income>> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM Income WHERE username = :username")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalIncome(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM Expense WHERE username = :username")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTotalExpense(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteIncome(@org.jetbrains.annotations.NotNull()
    com.example.budgettracker.Income i, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}