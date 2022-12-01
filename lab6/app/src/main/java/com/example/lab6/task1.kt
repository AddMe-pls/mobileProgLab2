package com.example.lab6

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import kotlin.concurrent.thread

class task1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        val viewRed = findViewById<View>(R.id.view_red)
        val viewYellow = findViewById<View>(R.id.view_yellow)
        val viewGreen = findViewById<View>(R.id.view_green)

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