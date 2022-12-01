package com.example.lab6

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.TextView

class task3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)

        val textView = findViewById<TextView>(R.id.text_view_animated)
        val animator = ObjectAnimator.ofPropertyValuesHolder(textView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y,  1880f),
                                                                        PropertyValuesHolder.ofFloat(View.ROTATION, 180f),
                                                                        PropertyValuesHolder.ofObject("textColor", ArgbEvaluator(), Color.GREEN, Color.RED))

        animator.duration = 3000
        textView.setOnTouchListener { view, motionEvent ->
            when(motionEvent.actionMasked){
                MotionEvent.ACTION_DOWN -> {
                    animator.start()
                }
                MotionEvent.ACTION_UP -> {
                    animator.reverse()
                }
            }
            true
        }
    }
}