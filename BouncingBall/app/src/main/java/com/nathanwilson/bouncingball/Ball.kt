package com.nathanwilson.bouncingball

import android.graphics.Canvas
import android.graphics.Paint

class Ball(val height: Float, val xPos: Float, var yPos:  Float) {
    private var yPos = 50f
    public fun update(delta: Long){
        yPos = (yPos + (9.8f * 100f) * (delta / 1000.0).toFloat())

    }

    public fun draw(canvas: Canvas, paint: Paint){
        canvas.drawCircle(100f, yPos, 50f, paint)
    }
}