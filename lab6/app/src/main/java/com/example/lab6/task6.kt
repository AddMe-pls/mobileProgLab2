package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

class task6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task6)

        val textView = findViewById<TextView>(R.id.text_view_timer)
        val buttonReset = findViewById<Button>(R.id.reset_button)
        val buttonTimer = findViewById<Button>(R.id.timer_button)
        var timer = Timer();
        var time = 0.0
        var isTimerOn = 0;

        buttonTimer.setOnClickListener {
            if (isTimerOn == 0) {
                timer.scheduleAtFixedRate(object : TimerTask() {
                    override fun run() {
                        time += 1
                        val timeInt = time.toInt()
                        val h = timeInt / 3600
                        val m = timeInt % 3600 / 60
                        val s = timeInt % 60

                        textView.text = String.format("%02d:%02d:%02d", h, m, s)
                    }
                }, 0, 1000)
                isTimerOn = 1
            } else {
                timer.cancel()
                timer = Timer()
                isTimerOn = 0
            }
        }

        buttonReset.setOnClickListener {
            time = 0.0
            textView.text = "00:00:00"
        }
    }
}