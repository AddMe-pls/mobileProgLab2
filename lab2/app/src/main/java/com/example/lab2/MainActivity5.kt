package com.example.lab2

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.core.view.ViewCompat

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val squareView = findViewById<View>(R.id.view10)

        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            squareView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 1000f),
            PropertyValuesHolder.ofFloat(View.SCALE_X, 3f),
            PropertyValuesHolder.ofFloat(View.SCALE_Y, 3f)
        )
        objectAnimator.duration = 5000
        objectAnimator.repeatCount = ObjectAnimator.INFINITE
        objectAnimator.repeatMode = ObjectAnimator.RESTART

        objectAnimator.start()

        /*
        ViewCompat.animate(view10)
            .translationY(1000f)
            .scaleX(2f)
            .scaleY(2f)
            .setDuration(3000)
    */
    }
}