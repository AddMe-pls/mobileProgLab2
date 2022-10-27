package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter

class task6 : AppCompatActivity() {
    private var tasks: ArrayList<HashMap<String, String>> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task6)

        tasks.add(hashMapOf("Date" to "17.02.2017", "Task" to "Do work"))
        tasks.add(hashMapOf("Date" to "", "Task" to "Go walk"))
        tasks.add(hashMapOf("Date" to "16.02.2017", "Task" to "Read book"))
        tasks.add(hashMapOf("Date" to "15.02.2017", "Task" to "Go to study"))

        val adapter = SimpleAdapter(this, tasks, R.layout.data_layout, arrayOf("Task", "Date"),
        intArrayOf(R.id.text_1, R.id.text_2))

        findViewById<ListView>(R.id.list_view).adapter = adapter
    }
}