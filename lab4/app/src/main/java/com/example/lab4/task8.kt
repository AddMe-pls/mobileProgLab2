package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2

class task8 : FragmentActivity() {

    private lateinit var adapter: NumberAdapter
    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task8)

        adapter = NumberAdapter(this)
        viewPager2 = findViewById(R.id.pager)
        viewPager2.adapter = adapter
    }
}