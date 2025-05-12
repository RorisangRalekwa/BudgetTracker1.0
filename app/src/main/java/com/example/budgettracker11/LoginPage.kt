package com.example.budgettracker11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val loginButton = findViewById<Button>(R.id.button5)
        loginButton.setOnClickListener {
            val enteredEmail = findViewById<EditText>(R.id.LoginEmail).text.toString()
            val enteredPassword = findViewById<EditText>(R.id.LoginPassword).text.toString()

            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            val savedEmail = sharedPref.getString("email", "")
            val savedPassword = sharedPref.getString("password", "")

            if (enteredEmail == savedEmail && enteredPassword == savedPassword) {
                val intent = Intent(this, ExpensesPage::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login failed. Check your credentials.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}