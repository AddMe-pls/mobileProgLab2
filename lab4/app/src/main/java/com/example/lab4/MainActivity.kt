package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button7).setOnClickListener { startActivity(Intent(this, task1::class.java)) }
        findViewById<Button>(R.id.button8).setOnClickListener { startActivity(Intent(this, task2::class.java)) }
        findViewById<Button>(R.id.button9).setOnClickListener { startActivity(Intent(this, task3::class.java)) }
        findViewById<Button>(R.id.button10).setOnClickListener { startActivity(Intent(this, task4::class.java)) }
        findViewById<Button>(R.id.button11).setOnClickListener { startActivity(Intent(this, task5::class.java)) }
        findViewById<Button>(R.id.button12).setOnClickListener { startActivity(Intent(this, task6::class.java)) }
        findViewById<Button>(R.id.button13).setOnClickListener { startActivity(Intent(this, task7::class.java)) }
        findViewById<Button>(R.id.button14).setOnClickListener { startActivity(Intent(this, task8::class.java)) }
        findViewById<Button>(R.id.button15).setOnClickListener { startActivity(Intent(this, task9::class.java)) }
        findViewById<Button>(R.id.button16).setOnClickListener { startActivity(Intent(this, task10::class.java)) }
        findViewById<Button>(R.id.button17).setOnClickListener { startActivity(Intent(this, task11::class.java)) }
    }
}