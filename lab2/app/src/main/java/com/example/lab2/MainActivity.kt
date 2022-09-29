package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button2).setOnClickListener { startActivity(Intent(this, MainActivity2::class.java)) }
        findViewById<Button>(R.id.button3).setOnClickListener { startActivity(Intent(this, MainActivity3::class.java)) }
        findViewById<Button>(R.id.button4).setOnClickListener { startActivity(Intent(this, MainActivity4::class.java)) }
        findViewById<Button>(R.id.button5).setOnClickListener { startActivity(Intent(this, MainActivity5::class.java)) }
        findViewById<Button>(R.id.button6).setOnClickListener { startActivity(Intent(this, MainActivity6::class.java)) }
    }
}

