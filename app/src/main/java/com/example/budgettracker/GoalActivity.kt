package com.example.budgettracker

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class GoalActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var etMonth: TextInputEditText
    private lateinit var etMinGoal: TextInputEditText
    private lateinit var etMaxGoal: TextInputEditText
    private lateinit var btnSaveGoal: Button
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        db = AppDatabase.getDB(this)
        username = intent.getStringExtra("USERNAME")
        
        etMonth = findViewById(R.id.etMonth)
        etMinGoal = findViewById(R.id.etMinGoal)
        etMaxGoal = findViewById(R.id.etMaxGoal)
        btnSaveGoal = findViewById(R.id.btnSaveGoal)

        // Set current month as default
        val sdf = SimpleDateFormat("yyyy-MM", Locale.getDefault())
        etMonth.setText(sdf.format(Date()))

        btnSaveGoal.setOnClickListener {
            saveGoal()
        }
    }

    private fun saveGoal() {
        val month = etMonth.text.toString()
        val minStr = etMinGoal.text.toString()
        val maxStr = etMaxGoal.text.toString()
        val user = username ?: return

        if (month.isEmpty() || !month.matches(Regex("\\d{4}-\\d{2}"))) {
            etMonth.error = "Invalid format (yyyy-MM)"
            return
        }

        val min = minStr.toDoubleOrNull() ?: 0.0
        val max = maxStr.toDoubleOrNull() ?: 0.0

        if (max < min && max != 0.0) {
            Toast.makeText(this, "Max goal should be greater than min goal", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            db.dao().insertGoal(Goal(monthYear = month, username = user, minGoal = min, maxGoal = max))
            Toast.makeText(this@GoalActivity, "Goal saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
