package com.example.loginsqlite

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginsqlite.databinding.ActivitySignBinding

class SignActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignBinding
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun clickSign(view: View) {
        val email = binding.emailEditText.text.toString().trim()
        val password = binding.passwordEditText.text.toString().trim()
        val rePassword = binding.rePasswordEditText.text.toString().trim()
        val name = binding.nameEditText.text.toString().trim()
        val surname = binding.surnameEditText.text.toString().trim()
        if (email.isEmpty() || password.isEmpty() || rePassword.isEmpty() || name.isEmpty() || surname.isEmpty()) {
            showToast("Please fill all fields!")
        } else if (password != rePassword) {
            showToast("Passwords do not match!")
        } else {
            db = openOrCreateDatabase("users", MODE_PRIVATE, null)
            db.execSQL("CREATE TABLE IF NOT EXISTS users (userId INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT, name TEXT, surname TEXT)")
            val cursor: Cursor = db.rawQuery("SELECT * FROM users WHERE email=?", arrayOf(email))
            if (cursor.count > 0) {
                showToast("User already exists!")
            } else {
                db.execSQL(
                    "INSERT INTO users (email, password, name, surname) VALUES (?,?,?,?)",
                    arrayOf(email, password, name, surname)
                )
                showToast("User created successfully!")
            }
        }
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}