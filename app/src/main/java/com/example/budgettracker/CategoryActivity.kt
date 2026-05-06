package com.example.budgettracker

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class CategoryActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var etCategory: EditText
    private lateinit var btnAddCat: Button
    private lateinit var lvCategories: ListView
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        db = AppDatabase.getDB(this)
        username = intent.getStringExtra("USERNAME")
        
        etCategory = findViewById(R.id.etCategory)
        btnAddCat = findViewById(R.id.btnAddCat)
        lvCategories = findViewById(R.id.lvCategories)

        loadCategories()

        btnAddCat.setOnClickListener {
            saveCategory()
        }
    }

    private fun loadCategories() {
        val user = username ?: return
        lifecycleScope.launch {
            val categories = db.dao().getCategories(user)
            val adapter = ArrayAdapter(this@CategoryActivity, android.R.layout.simple_list_item_1, categories.map { it.name })
            lvCategories.adapter = adapter
        }
    }

    private fun saveCategory() {
        val name = etCategory.text.toString().trim()
        val user = username ?: return
        
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter a category name", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            db.dao().insertCategory(Category(name = name, username = user))
            etCategory.text.clear()
            Toast.makeText(this@CategoryActivity, "Saved", Toast.LENGTH_SHORT).show()
            loadCategories()
        }
    }
}
