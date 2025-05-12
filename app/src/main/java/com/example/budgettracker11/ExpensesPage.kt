package com.example.budgettracker11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ExpensesPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses_page)

        val enterButton = findViewById<Button>(R.id.button7)
        enterButton.setOnClickListener {
            val category = findViewById<EditText>(R.id.ExpenseCategory).text.toString()
            val item = findViewById<EditText>(R.id.ExpenseItems).text.toString()
            val amount = findViewById<EditText>(R.id.ExpensesAmount).text.toString()

            val sharedPref = getSharedPreferences("ExpenseData", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("category", category)
                putString("item", item)
                putString("amount", amount)
                apply()
            }

            Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show()
        }

    }
}