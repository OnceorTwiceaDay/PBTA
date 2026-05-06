package com.example.budgettracker

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ExpenseAdapter
    private lateinit var db: AppDatabase
    private var currentUsername: String? = null
    private lateinit var tvTotalBalance: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        db = AppDatabase.getDB(this)
        currentUsername = intent.getStringExtra("USERNAME")
        tvTotalBalance = findViewById(R.id.tvTotalBalance)
        
        setupNavigation()
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        loadTransactions()
        loadBalance()
    }

    private fun setupNavigation() {
        findViewById<MaterialCardView>(R.id.cardAddIncome).setOnClickListener {
            val intent = Intent(this, AddIncomeActivity::class.java)
            intent.putExtra("USERNAME", currentUsername)
            startActivity(intent)
        }
        findViewById<MaterialCardView>(R.id.cardAddExpense).setOnClickListener {
            val intent = Intent(this, AddExpenseActivity::class.java)
            intent.putExtra("USERNAME", currentUsername)
            startActivity(intent)
        }
        findViewById<MaterialCardView>(R.id.cardCategories).setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            intent.putExtra("USERNAME", currentUsername)
            startActivity(intent)
        }
        findViewById<MaterialCardView>(R.id.cardReport).setOnClickListener {
            val intent = Intent(this, ReportActivity::class.java)
            intent.putExtra("USERNAME", currentUsername)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        val rvExpenses = findViewById<RecyclerView>(R.id.rvExpenses)
        rvExpenses.layoutManager = LinearLayoutManager(this)
        
        adapter = ExpenseAdapter(emptyList()) { item ->
            if (item.isExpense) {
                val intent = Intent(this, TransactionDetailActivity::class.java)
                intent.putExtra("EXPENSE_ID", item.id)
                intent.putExtra("USERNAME", currentUsername)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Income detail view not implemented", Toast.LENGTH_SHORT).show()
            }
        }
        rvExpenses.adapter = adapter

        // Swipe to delete
        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(rv: RecyclerView, vh: RecyclerView.ViewHolder, t: RecyclerView.ViewHolder) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val item = adapter.getTransactionAt(position)
                deleteTransaction(item)
            }
        }
        ItemTouchHelper(swipeHandler).attachToRecyclerView(rvExpenses)
    }

    private fun loadTransactions() {
        val username = currentUsername ?: return
        lifecycleScope.launch {
            val expenses = db.dao().getExpenses(username)
            val incomes = db.dao().getIncomes(username)
            
            val items = mutableListOf<TransactionItem>()
            items.addAll(expenses.map { TransactionItem(it.id, it.amount, it.description, it.date, true, it.category, !it.imageUri.isNullOrEmpty()) })
            items.addAll(incomes.map { TransactionItem(it.id, it.amount, it.description, it.date, false, "Income", false) })
            
            // Sort by date descending
            val sortedItems = items.sortedByDescending { it.date }
            adapter.updateData(sortedItems)
        }
    }

    private fun loadBalance() {
        val username = currentUsername ?: return
        lifecycleScope.launch {
            val totalIncome = db.dao().getTotalIncome(username) ?: 0.0
            val totalExpense = db.dao().getTotalExpense(username) ?: 0.0
            val balance = totalIncome - totalExpense
            tvTotalBalance.text = getString(R.string.balance_format, String.format("%.2f", balance))
        }
    }

    private fun deleteTransaction(item: TransactionItem) {
        lifecycleScope.launch {
            if (item.isExpense) {
                val expense = db.dao().getExpenseById(item.id)
                expense?.let { db.dao().deleteExpense(it) }
            } else {
                // We need a way to get income by ID or just delete by constructing object if possible
                // For now, let's assume we can get it or just delete.
                // Re-fetching incomes to find the one to delete
                val incomes = db.dao().getIncomes(currentUsername!!)
                val incomeToDelete = incomes.find { it.id == item.id }
                incomeToDelete?.let { db.dao().deleteIncome(it) }
            }
            Toast.makeText(this@MainActivity, "Transaction deleted", Toast.LENGTH_SHORT).show()
            loadTransactions()
            loadBalance()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                logout()
                true
            }
            R.id.action_switch_user -> {
                switchUser()
                true
            }
            R.id.action_delete_account -> {
                confirmDeleteAccount()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun switchUser() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun confirmDeleteAccount() {
        AlertDialog.Builder(this)
            .setTitle(R.string.delete_account)
            .setMessage(R.string.delete_account_confirm)
            .setPositiveButton(R.string.yes) { _, _ ->
                deleteAccount()
            }
            .setNegativeButton(R.string.no, null)
            .show()
    }

    private fun deleteAccount() {
        val username = currentUsername
        if (username != null) {
            lifecycleScope.launch {
                val user = db.dao().getUser(username)
                if (user != null) {
                    db.dao().deleteUser(user)
                    Toast.makeText(this@MainActivity, "Account deleted", Toast.LENGTH_SHORT).show()
                    logout()
                }
            }
        } else {
            Toast.makeText(this, "Error: User session not found", Toast.LENGTH_SHORT).show()
        }
    }
}
