package com.example.lab3

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.lang.Thread.sleep
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button3)

        button.setOnTouchListener {view: View, event: MotionEvent ->
            if(event.action == MotionEvent.ACTION_DOWN) {
                view.isPressed = true
                }
            true
        }

        val button2 = findViewById<Button>(R.id.button)
        val textview = findViewById<TextView>(R.id.textView)

        button2.setOnTouchListener {view, event ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.isPressed = true
                    textview.text = "Pressed"
                }
                MotionEvent.ACTION_UP -> {
                    view.isPressed = false
                    textview.text = "Released"
                }
            }
            true
        }

        val button3 = findViewById<Button>(R.id.button2)
        var counter = 0
        button3.setOnClickListener {
            counter += 1
            button3.text = "Counter $counter"
        }

        val button4 = findViewById<Button>(R.id.button5)
        val calendar = Calendar.getInstance()

        button4.setOnClickListener {
            val datePickerListener =
                DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                    Log.i(
                        "Date",
                        "$year-$month-$day"
                    )
                }
            DatePickerDialog(
                this, datePickerListener, calendar.get(Calendar.YEAR), calendar.get(
                    Calendar.MONTH
                ), calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val button5 = findViewById<Button>(R.id.button4)

        button5.setOnClickListener {
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                //calendar.set(Calendar.HOUR_OF_DAY, hour)
                //calendar.set(Calendar.MINUTE, minute)
                Log.i("Time", "$hour:$minute")
            }
            TimePickerDialog(
                this,
                timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            ).show()
        }

        val list = arrayOf("Android", "IOS", "Aurora")
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list)
        val spinner = findViewById<Spinner>(R.id.spinner)

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.i("Spinner", "Selected: " + list[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>) { }
        }

        val switch = findViewById<Switch>(R.id.switch1)
        switch?.setOnCheckedChangeListener({_, isChecked ->
            val message = if (isChecked) "On" else "Off"
            switch.text = message
        })

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val viewSeekBar = findViewById<TextView>(R.id.textView2)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                viewSeekBar.text = "Seek bar value: " + seekBar.progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}