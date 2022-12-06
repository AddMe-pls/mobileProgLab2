package com.example.lab8

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.ImageView

class task1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_task1)

        val myCanvas = MyCanvas(this)
        myCanvas.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        setContentView(myCanvas)
    }
}

private class MyCanvas (context: Context): View(context) {
    private val paint = Paint().apply {
        isAntiAlias = true
    }

    private var path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width : Float = width.toFloat()
        val height : Float = height.toFloat()

        paint.color = Color.BLUE
        canvas.drawRect(0f, 0f, width, height * 2 / 3, paint)

        paint.color = Color.GREEN
        canvas.drawRect(0f, height * 2 / 3, width, height, paint)

        paint.color = Color.RED
        canvas.drawRect(width / 2 + 100f, height / 4, width / 2 + 170f, height / 2, paint)

        paint.color = Color.parseColor("#DEB887")
        canvas.drawRect(width / 3, height / 2, width * 2 / 3, height * 4 / 5, paint)

        paint.color = Color.parseColor("#8B4513")
        path.moveTo(width / 4, height / 2)
        path.lineTo(width / 2, height / 3)
        path.lineTo(width * 3 / 4, height / 2)
        path.lineTo(width / 4, height / 2)

        canvas.drawPath(path, paint)
    }
}
