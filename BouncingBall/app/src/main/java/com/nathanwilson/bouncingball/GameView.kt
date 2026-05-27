package com.nathanwilson.bouncingball

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.Choreographer
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet

@SuppressLint("ClickableViewAccessibility")
class GameView(context : Context) : View(context), Choreographer.FrameCallback{
    private val choreographer = Choreographer.getInstance()
    private val paint = Paint()
    private val ball = Ball()
    private var lastUpdate = System.nanoTime()

    init {
        choreographer.postFrameCallback(this)
        setOnTouchListener{_: View, motionEvent: MotionEvent ->
            if(motionEvent.action == MotionEvent.ACTION_DOWN){

            }
            return@setOnTouchListener false

        }
    }

    override fun onDraw(canvas: Canvas) {
        ball.draw(canvas, paint)
    }

    override fun doFrame(delta: Long){
        ball.update(delta / 1000)
        choreographer.postFrameCallback(this)
        invalidate()

    }

}