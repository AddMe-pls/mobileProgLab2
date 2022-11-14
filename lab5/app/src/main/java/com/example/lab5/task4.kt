package com.example.lab5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.core.content.edit

class task4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task4)

        val editText = findViewById<EditText>(R.id.edit_text)
        val button = findViewById<Button>(R.id.button)
        val listView = findViewById<ListView>(R.id.list_view)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        var dataBase = HashSet(preferences.getStringSet("notes", hashSetOf()))

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        adapter.addAll(dataBase)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            dataBase.remove(adapter.getItem(i))
            adapter.remove(adapter.getItem(i))
            preferences.edit {
                putStringSet("notes", dataBase)
                commit()
            }
        }

        button.setOnClickListener {
            dataBase.add(editText.text.toString())
            adapter.add(editText.text.toString())
            editText.setText("")
            preferences.edit {
                putStringSet("notes", dataBase)
                commit()
            }
        }

        listView.adapter = adapter
    }
}