package com.example.lab6

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class task2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        val viewRed = findViewById<View>(R.id.view_red)
        val viewYellow = findViewById<View>(R.id.view_yellow)
        val viewGreen = findViewById<View>(R.id.view_green)
        val viewHuman = findViewById<View>(R.id.view_human)
        val animator = ObjectAnimator.ofFloat(viewHuman, View.TRANSLATION_X, 830f)
        animator.duration = 2000
        var humanHasCome = false

        val thread = Thread(Runnable {
            while (true) {
                runOnUiThread {
                    viewYellow.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
                    viewRed.backgroundTintList = ColorStateList.valueOf(Color.RED)
                }
                Thread.sleep(2000)
                runOnUiThread {
                    viewRed.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
                    viewYellow.backgroundTintList = ColorStateList.valueOf(Color.YELLOW)
                }
                Thread.sleep(2000)
                runOnUiThread {
                    viewYellow.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
                    viewGreen.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
                    if(!humanHasCome) {
                        humanHasCome = true
                        animator.start()
                    } else {
                        humanHasCome = false
                        animator.reverse()
                    }
                }
                Thread.sleep(2000)
                runOnUiThread {
                    viewGreen.backgroundTintList = ColorStateList.valueOf(Color.BLACK)
                    viewYellow.backgroundTintList = ColorStateList.valueOf(Color.YELLOW)
                }
                Thread.sleep(2000)
            }
        })
        thread.start()
    }
}