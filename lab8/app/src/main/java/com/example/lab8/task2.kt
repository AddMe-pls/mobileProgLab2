package com.example.lab8

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap

class task2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myCanvas = MyCanvasSprite(this)
        myCanvas.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(myCanvas)
    }
}

class MyCanvasSprite (context: Context): View(context) {
    private val paint = Paint().apply {
        isAntiAlias = true
    }

    private var bitmap1 : Bitmap = ResourcesCompat.getDrawable(resources, R.drawable.arrow_svgrepo_com, null)!!.toBitmap(100, 100)
    private var bitmap2 : Bitmap = Bitmap.createBitmap(ResourcesCompat.getDrawable(resources, R.drawable.arrow_svgrepo_com, null)!!.toBitmap(100, 100), 0, 0, 100, 100, Matrix().apply { preScale(-1f, 1f) }, false)
    private var bitmapX1 : Float = 0f
    private var bitmapY1 : Float = 500f
    private var bitmapX2 : Float = width.toFloat() - 50f
    private var bitmapY2 : Float = 700f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width : Float = width.toFloat()

        canvas.drawBitmap(bitmap1, bitmapX1, bitmapY1, paint)
        if (bitmapX1 > width)
            bitmapX1 = 0f
        else bitmapX1++

        canvas.drawBitmap(bitmap2, bitmapX2, bitmapY2, paint)
        if (bitmapX2 < 0f)
            bitmapX2 = width - 50f
        else bitmapX2--

        invalidate()
    }
}