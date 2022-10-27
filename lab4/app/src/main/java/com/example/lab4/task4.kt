package com.example.lab4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class task4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)

        val textView = findViewById<TextView>(R.id.textView3)
        val button = findViewById<Button>(R.id.button2)
        val calendar = Calendar.getInstance()

        button.setOnClickListener {
            val datePickerListener =
                DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                    textView.text = "$year-$month-$day"
                }
            DatePickerDialog(
                this, datePickerListener, calendar.get(Calendar.YEAR), calendar.get(
                    Calendar.MONTH
                ), calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }
}