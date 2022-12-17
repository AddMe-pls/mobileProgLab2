package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var counter = 0

        findViewById<Button>(R.id.button).setOnClickListener {
            counter++
            findViewById<TextView>(R.id.text_view).text = counter.toString()
        }
    }
}