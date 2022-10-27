package com.example.lab4

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import java.lang.Math.abs


class task9 : AppCompatActivity(), GestureDetector.OnGestureListener {

    lateinit var gestureDetector: GestureDetector
    var x1:Float = 0.0f
    var x2:Float = 0.0f
    var y1:Float = 0.0f
    var y2:Float = 0.0f

    companion object {
        const val MIN_DISTANCE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task9)

        gestureDetector = GestureDetector(this, this)
    }

        override fun onTouchEvent(event: MotionEvent?): Boolean {

        //gestureDetector.onTouchEvent(event)

        when(event?.action) {
            0->
            {
                x1 = event.x
                y1 = event.y
            }

            1->
            {
                x2 = event.x
                y2 = event.y

                val valueX:Float = x2-x1
                val valueY:Float = y2-y1

                if (abs(valueY) > MIN_DISTANCE) {
                    if (y2 > y1) {
                        //Toast.makeText(this,"Bot swipe", Toast.LENGTH_SHORT).show()
                        val topView = findViewById<View>(R.id.top_line)

                        val popupMenu: PopupMenu = PopupMenu(this, topView)
                        popupMenu.inflate(R.menu.popup_menu)
                        popupMenu.show()
                    }
                    else {

                        //Toast.makeText(this,"Top swipe", Toast.LENGTH_SHORT).show()
                        val botView = findViewById<View>(R.id.bot_line)

                        val popupMenu: PopupMenu = PopupMenu(this, botView)
                        popupMenu.inflate(R.menu.popup_menu)
                        popupMenu.setOnMenuItemClickListener {
                            true
                        }
                        popupMenu.show()
                    }
                }


            }
        }


        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onShowPress(p0: MotionEvent?) {
        TODO("Not yet implemented")
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        TODO("Not yet implemented")
    }

    override fun onLongPress(p0: MotionEvent?) {
        TODO("Not yet implemented")
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        TODO("Not yet implemented")
    }
}