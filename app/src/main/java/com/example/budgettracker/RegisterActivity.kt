package com.example.budgettracker

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        db = AppDatabase.getDB(this)

        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<TextInputEditText>(R.id.etConfirmPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, getString(R.string.passwords_do_not_match), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isValidPassword(password)) {
                Toast.makeText(this, getString(R.string.invalid_password_format), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val existingUser = db.dao().getUser(username)
                if (existingUser != null) {
                    Toast.makeText(this@RegisterActivity, getString(R.string.username_exists), Toast.LENGTH_SHORT).show()
                } else {
                    db.dao().insertUser(User(username, password))
                    Toast.makeText(this@RegisterActivity, getString(R.string.registration_success), Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"
        return password.matches(Regex(passwordPattern))
    }
}
