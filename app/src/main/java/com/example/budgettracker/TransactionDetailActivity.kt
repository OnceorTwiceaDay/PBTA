package com.example.budgettracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class TransactionDetailActivity : AppCompatActivity() {

    private lateinit var etAmount: TextInputEditText
    private lateinit var etDesc: TextInputEditText
    private lateinit var etDate: TextInputEditText
    private lateinit var etCategory: TextInputEditText
    private lateinit var etStartTime: TextInputEditText
    private lateinit var etEndTime: TextInputEditText
    private lateinit var ivPhoto: ImageView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button
    
    private lateinit var db: AppDatabase
    private var expenseId: Int = -1
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_detail)

        db = AppDatabase.getDB(this)
        expenseId = intent.getIntExtra("EXPENSE_ID", -1)
        username = intent.getStringExtra("USERNAME")

        initViews()

        if (expenseId != -1) {
            loadExpenseDetails()
        } else {
            Toast.makeText(this, "Error: Transaction not found", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnUpdate.setOnClickListener { updateExpense() }
        btnDelete.setOnClickListener { deleteExpense() }
    }

    private fun initViews() {
        etAmount = findViewById(R.id.etAmount)
        etDesc = findViewById(R.id.etDesc)
        etDate = findViewById(R.id.etDate)
        etCategory = findViewById(R.id.etCategory)
        etStartTime = findViewById(R.id.etStartTime)
        etEndTime = findViewById(R.id.etEndTime)
        ivPhoto = findViewById(R.id.ivPhoto)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }

    private fun loadExpenseDetails() {
        lifecycleScope.launch {
            val expense = db.dao().getExpenseById(expenseId)
            expense?.let {
                etAmount.setText(it.amount.toString())
                etDesc.setText(it.description)
                etDate.setText(it.date)
                etCategory.setText(it.category)
                etStartTime.setText(it.startTime)
                etEndTime.setText(it.endTime)
                
                if (!it.imageUri.isNullOrEmpty()) {
                    ivPhoto.visibility = View.VISIBLE
                    ivPhoto.setImageURI(it.imageUri.toUri())
                }
            }
        }
    }

    private fun updateExpense() {
        val amountStr = etAmount.text.toString()
        val description = etDesc.text.toString()
        val category = etCategory.text.toString()

        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val expense = db.dao().getExpenseById(expenseId)
            expense?.let {
                val updatedExpense = it.copy(
                    amount = amountStr.toDoubleOrNull() ?: it.amount,
                    description = description,
                    category = category
                )
                db.dao().updateExpense(updatedExpense)
                Toast.makeText(this@TransactionDetailActivity, "Updated successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun deleteExpense() {
        lifecycleScope.launch {
            val expense = db.dao().getExpenseById(expenseId)
            expense?.let {
                db.dao().deleteExpense(it)
                Toast.makeText(this@TransactionDetailActivity, "Deleted successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
