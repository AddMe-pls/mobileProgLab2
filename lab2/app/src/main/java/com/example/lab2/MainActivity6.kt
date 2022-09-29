package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val editText = findViewById<EditText>(R.id.editTextTextPersonName2)
        val editText2 = findViewById<EditText>(R.id.editTextTextPersonName3);
        val textView = findViewById<View>(R.id.textView6);
        val button = findViewById<Button>(R.id.button);

        button.setOnClickListener {
            val firstNumber = editText.text.toString().toDouble()
            val secondNumber = editText2.text.toString().toDouble()
            val summ = firstNumber.toDouble() + secondNumber.toDouble()

            println(summ)
            //textView.text = summ.toString()
        }
    }
}