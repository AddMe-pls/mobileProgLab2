package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class task1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        val textView = findViewById<TextView>(R.id.text_view)
        val count = Counter(0)

        findViewById<Button>(R.id.button_increase).setOnClickListener {
            count.increase()
            textView.text = count.counter.toString()
        }
        findViewById<Button>(R.id.button_reset).setOnClickListener {
            count.reset()
            textView.text = count.counter.toString()
        }
    }
}

class Counter(count_param : Int) {
    var counter = count_param;

    fun increase() {
        counter++;
    }
    fun reset() {
        counter = 0;
    }
}