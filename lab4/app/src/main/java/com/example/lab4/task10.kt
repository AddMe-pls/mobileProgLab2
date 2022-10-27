package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class task10 : AppCompatActivity() {
    private val contact = arrayOf("John", "Andrey", "Gleb", "Misha", "Lexxxa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task10)

        val arrayAdapter: ArrayAdapter<Any> = ArrayAdapter(this, android.R.layout.simple_list_item_1, contact)

        val listView = findViewById<ListView>(R.id.list_view_context)
        listView.adapter = arrayAdapter
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val arrayNumber = ((item.menuInfo as AdapterView.AdapterContextMenuInfo).targetView as TextView).text
        return when (item!!.itemId) {
            R.id.call -> {
                Log.i("menu_info", "$arrayNumber: call")
                return true
            }
            R.id.sms -> {
                Log.i("menu_info", "$arrayNumber: sms")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }


        return super.onContextItemSelected(item)
    }
}