package com.example.budgettracker11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpButton = findViewById<Button>(R.id.SignupButton)
        signUpButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.SignupName).text.toString()
            val email = findViewById<EditText>(R.id.SignupEmail).text.toString()
            val password = findViewById<EditText>(R.id.SignupPassword).text.toString()

            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("name", name)
                putString("email", email)
                putString("password", password)
                apply()
            }

            Toast.makeText(this, "User sign-up successful", Toast.LENGTH_SHORT).show()
        }

    }
}