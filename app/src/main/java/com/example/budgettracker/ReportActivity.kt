package com.example.budgettracker

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ReportActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private var startDate = Calendar.getInstance().apply { add(Calendar.MONTH, -1) }
    private var endDate = Calendar.getInstance()
    private var username: String? = null
    
    private lateinit var btnStartDate: Button
    private lateinit var btnEndDate: Button
    private lateinit var tvGoals: TextView
    private lateinit var tvIncomeSummary: TextView
    private lateinit var txtCategoryTotals: TextView
    private lateinit var rvFilteredExpenses: RecyclerView
    private lateinit var btnSetGoals: Button
    private lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        db = AppDatabase.getDB(this)
        username = intent.getStringExtra("USERNAME")
        
        initViews()
        setupDatePickers()
        setupRecyclerView()
        
        btnSetGoals.setOnClickListener {
            val intent = Intent(this, GoalActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
        }

        loadReport()
    }

    private fun initViews() {
        btnStartDate = findViewById(R.id.btnStartDate)
        btnEndDate = findViewById(R.id.btnEndDate)
        tvGoals = findViewById(R.id.tvGoals)
        tvIncomeSummary = findViewById(R.id.tvIncomeSummary)
        txtCategoryTotals = findViewById(R.id.txtCategoryTotals)
        rvFilteredExpenses = findViewById(R.id.rvFilteredExpenses)
        btnSetGoals = findViewById(R.id.btnSetGoals)
        
        updateDateButtons()
    }

    private fun setupDatePickers() {
        btnStartDate.setOnClickListener {
            DatePickerDialog(this, { _, year, month, day ->
                startDate.set(year, month, day)
                updateDateButtons()
                loadReport()
            }, startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnEndDate.setOnClickListener {
            DatePickerDialog(this, { _, year, month, day ->
                endDate.set(year, month, day)
                updateDateButtons()
                loadReport()
            }, endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH), endDate.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    private fun updateDateButtons() {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        btnStartDate.text = format.format(startDate.time)
        btnEndDate.text = format.format(endDate.time)
    }

    private fun setupRecyclerView() {
        rvFilteredExpenses.layoutManager = LinearLayoutManager(this)
        adapter = ExpenseAdapter(emptyList()) { item ->
            if (item.isExpense) {
                val intent = Intent(this, TransactionDetailActivity::class.java)
                intent.putExtra("EXPENSE_ID", item.id)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }
        rvFilteredExpenses.adapter = adapter
    }

    private fun loadReport() {
        val user = username ?: return
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val startStr = format.format(startDate.time)
        val endStr = format.format(endDate.time)

        lifecycleScope.launch {
            val expenses = db.dao().getExpensesByDateRange(user, startStr, endStr)
            val transactionItems = expenses.map { TransactionItem(it.id, it.amount, it.description, it.date, true, it.category, !it.imageUri.isNullOrEmpty()) }
            adapter.updateData(transactionItems)

            val totals = db.dao().getCategoryTotals(user, startStr, endStr)
            val totalsText = totals.joinToString("\n") { "${it.categoryName}: R${it.totalAmount}" }
            txtCategoryTotals.text = if (totalsText.isEmpty()) getString(R.string.no_data_period) else totalsText
            
            val totalIncome = db.dao().getTotalIncome(user) ?: 0.0
            tvIncomeSummary.text = getString(R.string.total_income_display, String.format("%.2f", totalIncome))

            val monthYear = SimpleDateFormat("yyyy-MM", Locale.getDefault()).format(startDate.time)
            val goal = db.dao().getGoal(user, monthYear)
            if (goal != null) {
                tvGoals.text = getString(R.string.goal_display, monthYear, goal.minGoal, goal.maxGoal)
            } else {
                tvGoals.text = getString(R.string.no_goal_set, monthYear)
            }
        }
    }
}
