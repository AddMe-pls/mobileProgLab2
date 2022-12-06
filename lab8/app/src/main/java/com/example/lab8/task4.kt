package com.example.lab8

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import kotlin.random.Random

class task4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myCanvas = MyCanvasFantan(this)
        myCanvas.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(myCanvas)
    }
}

private class MyCanvasFantan(context: Context): View(context) {
    private var particleList : ArrayList<Particles> = arrayListOf()
    private var rand : Random = Random.Default

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        val currentVx = (rand.nextFloat() - 0.5f) * 10f
        val currentVy = (rand.nextFloat() - 2)  * 10f
        particleList.add(Particles(5f, width / 2f, height.toFloat() ,currentVx, currentVy))


        for (particle : Int in particleList.indices.reversed()) {
            if ((particleList[particle].x > width) or (particleList[particle].x < 0) or (particleList[particle].y > height) or (particleList[particle].y < 0))
                particleList.removeAt(particle)
        }

        for (particle : Particles in particleList) {
            particle.x += particle.vx
            particle.y += particle.vy
            particle.vy += 0.2f
        }

        for (particle in particleList) {
            canvas.drawCircle(particle.x, particle.y, particle.radius, paint)
        }
        invalidate()
    }
}