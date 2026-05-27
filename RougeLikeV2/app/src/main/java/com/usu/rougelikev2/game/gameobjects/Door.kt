package com.usu.rougelikev2.game.gameobjects


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject
import com.usu.rougelikev2.game.gameengine.Location


class Door(game: Game?) : GameObject(game!!) {
    override fun render(canvas: Canvas, paint: Paint) {
//        things you can do in this render method for reference.
//        val coords: Location = state["coords"] // gets the location of the object in the grid
//        val cellSize: Int = game.gameState["cellSize"] // gets the size of each cell in the game
//        val myX = coords.x * cellSize // gets the current x position (in pixels) in screen space
//        val myY = coords.y * cellSize // gets the current y position (in pixels) in screen space

        val coords: Location = state["coords"]
        val cellSize: Int = game.gameState["cellSize"]
        val myX = coords.x * cellSize
        val myY = coords.y * cellSize

        canvas.translate(myX, myY)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 2f
        paint.color = Color.LTGRAY
        paint.style = Paint.Style.FILL
        canvas.drawRect(30f, 10f, (cellSize - 30).toFloat(), (cellSize - 10).toFloat(), paint)
        paint.color = Color.BLACK
        canvas.drawRect(cellSize-50.toFloat(), 30f, (cellSize - 30).toFloat(), (50f), paint)
        canvas.drawRect(cellSize-50.toFloat(), (cellSize - 30f), (cellSize - 30).toFloat(), (cellSize -50f), paint)
        canvas.drawRect(45f, cellSize - 75f, 65f, cellSize - 65f, paint)
        canvas.drawCircle(55f, cellSize - 60f,10f, paint)
        paint.color = Color.LTGRAY
        canvas.drawCircle(55f, cellSize - 60f,8f, paint)
    }
}