package com.example.lab5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.core.content.edit
import androidx.core.widget.doOnTextChanged

class task5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task5)

        val editText = findViewById<EditText>(R.id.edit_text)
        val checkBox = findViewById<CheckBox>(R.id.check_box)
        val preferences = getPreferences(Context.MODE_PRIVATE)

        checkBox.isChecked = preferences.getBoolean("check_box", false)
        editText.setText(preferences.getString("edit_text", ""))

        editText.doOnTextChanged { text, start, before, count ->
            preferences.edit {
                putString("edit_text", text.toString())
                apply()
            }
        }

        checkBox.setOnClickListener {
            preferences.edit {
                putBoolean("check_box", checkBox.isChecked)
                apply()
            }
        }
    }
}