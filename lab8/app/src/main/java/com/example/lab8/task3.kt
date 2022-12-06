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

class task3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task3)

        val myCanvas = MyCanvasParticles(this)
        myCanvas.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(myCanvas)
    }
}

class Particles
    (var radius : Float = 5f,
     var x : Float = 0f,
     var y : Float = 0f,
     var vx : Float = 0f,
     var vy : Float = 0f) { }

private class MyCanvasParticles(context: Context): View(context) {
    private var touched : Boolean = false
    private var currentx : Float = 0f
    private var currenty : Float = 0f
    private var particleList : ArrayList<Particles> = arrayListOf()
    private var rand : Random = Random.Default

    private val paint = Paint().apply {
        isAntiAlias = true
        color = Color.BLACK
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (touched) {
            val currentVx = (rand.nextFloat() - 0.5f) * 10f
            val currentVy = (rand.nextFloat() - 0.5f) * 10f
            particleList.add(Particles(5f, currentx, currenty,currentVx, currentVy))
        }

        for (particle : Particles in particleList.reversed()) {
            if ((particle.x > width) or (particle.x < 0) or ( particle.y > height) or (particle.y < 0))
                particleList.remove(particle)
        }

        for (particle : Particles in particleList) {
            particle.x += particle.vx
            particle.y += particle.vy
        }

        for (particle in particleList) {
            canvas.drawCircle(particle.x, particle.y, particle.radius, paint)
        }
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                currentx = event.x
                currenty = event.y
                touched = true
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                touched = false
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                currentx = event.x
                currenty = event.y
                touched = true
                invalidate()
            }
        }
        return true
    }
}