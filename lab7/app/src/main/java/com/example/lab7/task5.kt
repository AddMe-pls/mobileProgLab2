package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class task5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task5)

        val editText = findViewById<EditText>(R.id.edit_text)
        val textView = findViewById<TextView>(R.id.text_view_list)

        val myList = ListOfStr()

        findViewById<Button>(R.id.button_add).setOnClickListener {
            val newStr = editText.text.toString()
            myList.addStr(newStr)
            textView.text = myList.strList
        }

        findViewById<Button>(R.id.button_remove).setOnClickListener {
            myList.removeLast()
            textView.text = myList.strList
        }
    }
}

class ListOfStr() {
    var list = ArrayList<String>()
    var strList = ""

    fun addStr(str : String) {
        list.add(str)
        if (list.size > 1)
            strList += ", "
        strList += str
    }

    fun removeLast() {
        list.removeLast()

        if (list.size != 0) {
            val tmpStr = strList.substringBeforeLast(",")
            strList = tmpStr
        } else strList = ""
    }
}