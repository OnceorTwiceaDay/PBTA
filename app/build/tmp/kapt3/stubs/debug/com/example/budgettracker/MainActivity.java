package com.example.budgettracker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0014J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/example/budgettracker/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/budgettracker/ExpenseAdapter;", "currentUsername", "", "db", "Lcom/example/budgettracker/AppDatabase;", "tvTotalBalance", "Landroid/widget/TextView;", "confirmDeleteAccount", "", "deleteAccount", "deleteTransaction", "item", "Lcom/example/budgettracker/TransactionItem;", "loadBalance", "loadTransactions", "logout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "Landroid/view/MenuItem;", "onResume", "setupNavigation", "setupRecyclerView", "switchUser", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.budgettracker.ExpenseAdapter adapter;
    private com.example.budgettracker.AppDatabase db;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currentUsername;
    private android.widget.TextView tvTotalBalance;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void setupNavigation() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void loadTransactions() {
    }
    
    private final void loadBalance() {
    }
    
    private final void deleteTransaction(com.example.budgettracker.TransactionItem item) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void logout() {
    }
    
    private final void switchUser() {
    }
    
    private final void confirmDeleteAccount() {
    }
    
    private final void deleteAccount() {
    }
}