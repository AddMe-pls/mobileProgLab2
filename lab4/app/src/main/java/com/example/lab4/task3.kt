package com.example.lab4

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class task3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)

        val textView = findViewById<TextView>(R.id.textView2)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.button_layout, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.editText)

            with(builder) {
                setTitle("Enter text:")
                setPositiveButton("OK"){ dialog, which ->
                    textView.text = editText.text.toString()
                }
                setView(dialogLayout)
                show()
            }
        }
    }
}