package com.example.budgettracker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private var selectedDate = Calendar.getInstance()
    private var startTime = Calendar.getInstance()
    private var endTime = Calendar.getInstance()
    private var imageUri: Uri? = null
    private var username: String? = null

    private lateinit var etAmount: TextInputEditText
    private lateinit var etDesc: TextInputEditText
    private lateinit var btnDate: Button
    private lateinit var btnStartTime: Button
    private lateinit var btnEndTime: Button
    private lateinit var spCategory: Spinner
    private lateinit var ivPhoto: ImageView
    private lateinit var btnAddPhoto: Button
    private lateinit var btnSave: Button

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            contentResolver.takePersistableUriPermission(it, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            imageUri = it
            ivPhoto.visibility = View.VISIBLE
            ivPhoto.setImageURI(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        db = AppDatabase.getDB(this)
        username = intent.getStringExtra("USERNAME")
        
        initViews()
        setupDateTimePickers()
        loadCategories()
        setupPhotoPicker()
        setupSaveButton()
    }

    private fun initViews() {
        etAmount = findViewById(R.id.etAmount)
        etDesc = findViewById(R.id.etDesc)
        btnDate = findViewById(R.id.btnDate)
        btnStartTime = findViewById(R.id.btnStartTime)
        btnEndTime = findViewById(R.id.btnEndTime)
        spCategory = findViewById(R.id.spCategory)
        ivPhoto = findViewById(R.id.ivPhoto)
        btnAddPhoto = findViewById(R.id.btnAddPhoto)
        btnSave = findViewById(R.id.btnSave)

        updateDateButtonText()
        updateStartTimeButtonText()
        updateEndTimeButtonText()
    }

    private fun setupDateTimePickers() {
        btnDate.setOnClickListener {
            DatePickerDialog(this, { _, year, month, day ->
                selectedDate.set(year, month, day)
                updateDateButtonText()
            }, selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH)).show()
        }

        btnStartTime.setOnClickListener {
            TimePickerDialog(this, { _, hour, minute ->
                startTime.set(Calendar.HOUR_OF_DAY, hour)
                startTime.set(Calendar.MINUTE, minute)
                updateStartTimeButtonText()
            }, startTime.get(Calendar.HOUR_OF_DAY), startTime.get(Calendar.MINUTE), true).show()
        }

        btnEndTime.setOnClickListener {
            TimePickerDialog(this, { _, hour, minute ->
                endTime.set(Calendar.HOUR_OF_DAY, hour)
                endTime.set(Calendar.MINUTE, minute)
                updateEndTimeButtonText()
            }, endTime.get(Calendar.HOUR_OF_DAY), endTime.get(Calendar.MINUTE), true).show()
        }
    }

    private fun updateDateButtonText() {
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        btnDate.text = format.format(selectedDate.time)
    }

    private fun updateStartTimeButtonText() {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        btnStartTime.text = getString(R.string.start_time, format.format(startTime.time))
    }

    private fun updateEndTimeButtonText() {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        btnEndTime.text = getString(R.string.end_time, format.format(endTime.time))
    }

    private fun loadCategories() {
        val user = username ?: return
        lifecycleScope.launch {
            val categories = db.dao().getCategories(user).map { it.name }
            if (categories.isEmpty()) {
                db.dao().insertCategory(Category(name = "General", username = user))
                loadCategories()
                return@launch
            }
            val adapter = ArrayAdapter(this@AddExpenseActivity, android.R.layout.simple_spinner_item, categories)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spCategory.adapter = adapter
        }
    }

    private fun setupPhotoPicker() {
        btnAddPhoto.setOnClickListener {
            pickImage.launch("image/*")
        }
    }

    private fun setupSaveButton() {
        btnSave.setOnClickListener {
            val amountStr = etAmount.text.toString()
            val description = etDesc.text.toString()
            val category = spCategory.selectedItem?.toString() ?: "General"
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

            if (description.isEmpty()) {
                etDesc.error = "Description is required"
                return@setOnClickListener
            }

            if (endTime.before(startTime)) {
                Toast.makeText(this, "End time must be after start time", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            val expense = Expense(
                amount = amount,
                description = description,
                date = dateFormat.format(selectedDate.time),
                startTime = timeFormat.format(startTime.time),
                endTime = timeFormat.format(endTime.time),
                category = category,
                imageUri = imageUri?.toString(),
                username = user
            )

            lifecycleScope.launch {
                db.dao().insertExpense(expense)
                Toast.makeText(this@AddExpenseActivity, "Expense saved", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
