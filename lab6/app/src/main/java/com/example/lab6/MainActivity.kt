package com.example.lab6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.task1).setOnClickListener { startActivity(Intent(this, task1::class.java)) }
        findViewById<Button>(R.id.task2).setOnClickListener { startActivity(Intent(this, task2::class.java)) }
        findViewById<Button>(R.id.task3).setOnClickListener { startActivity(Intent(this, task3::class.java)) }
        val task4  = findViewById<Button>(R.id.task4).also { it.setOnClickListener { startActivity(Intent(this, task4::class.java)) }}
        val task5 = findViewById<Button>(R.id.task5).also { it.setOnClickListener { startActivity(Intent(this, task5::class.java)) } }
        findViewById<Button>(R.id.task6).setOnClickListener { startActivity(Intent(this, task6::class.java)) }
        findViewById<Button>(R.id.task7).setOnClickListener { startActivity(Intent(this, task7::class.java)) }
        task4.visibility = View.GONE
        task5.visibility = View.GONE
    }
}