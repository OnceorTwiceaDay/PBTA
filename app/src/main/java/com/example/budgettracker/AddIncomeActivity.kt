package com.example.budgettracker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddIncomeActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private var selectedDate = Calendar.getInstance()
    private var selectedTime = Calendar.getInstance()
    private var username: String? = null

    private lateinit var etAmount: TextInputEditText
    private lateinit var etDesc: TextInputEditText
    private lateinit var btnDate: Button
    private lateinit var btnTime: Button
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_income)

        db = AppDatabase.getDB(this)
        username = intent.getStringExtra("USERNAME")

        initViews()
        setupDateTimePickers()
        setupSaveButton()
    }

    private fun initViews() {
        etAmount = findViewById(R.id.etAmount)
        etDesc = findViewById(R.id.etDesc)
        btnDate = findViewById(R.id.btnDate)
        btnTime = findViewById(R.id.btnTime)
        btnSave = findViewById(R.id.btnSave)

        updateDateButtonText()
        updateTimeButtonText()
    }

    private fun setupDateTimePickers() {
        btnDate.setOnClickListener {
            DatePickerDialog(this, { _, year, month, day ->
                selectedDate.set(year, month, day)
                updateDateButtonText()
            }, selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnTime.setOnClickListener {
            TimePickerDialog(this, { _, hour, minute ->
                selectedTime.set(Calendar.HOUR_OF_DAY, hour)
                selectedTime.set(Calendar.MINUTE, minute)
                updateTimeButtonText()
            }, selectedTime.get(Calendar.HOUR_OF_DAY), selectedTime.get(Calendar.MINUTE), true).show()
        }
    }

    private fun updateDateButtonText() {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        btnDate.text = format.format(selectedDate.time)
    }

    private fun updateTimeButtonText() {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        btnTime.text = format.format(selectedTime.time)
    }

    private fun setupSaveButton() {
        btnSave.setOnClickListener {
            val amountStr = etAmount.text.toString()
            val description = etDesc.text.toString()
            val user = username ?: return@setOnClickListener

            if (amountStr.isEmpty()) {
                etAmount.error = "Amount is required"
                return@setOnClickListener
            }

            val amount = amountStr.toDoubleOrNull()
            if (amount == null || amount <= 0) {
                etAmount.error = "Invalid amount"
                return@setOnClickListener
            }

            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            val income = Income(
                amount = amount,
                description = description,
                date = dateFormat.format(selectedDate.time),
                time = timeFormat.format(selectedTime.time),
                username = user
            )

            lifecycleScope.launch {
                db.dao().insertIncome(income)
                Toast.makeText(this@AddIncomeActivity, "Income saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
