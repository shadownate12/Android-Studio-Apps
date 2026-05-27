package com.usu.rougelikev2.game.gameobjects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject
import com.usu.rougelikev2.game.gameengine.Location


class BossBarrier(game: Game?) : GameObject(game!!) {
    override fun render(canvas: Canvas, paint: Paint) {
//        things you can do in this render method for reference.
//        val coords: Location = state["coords"] // gets the location of the object in the grid
//        val cellSize: Int = game.gameState["cellSize"] // gets the size of each cell in the game
//        val myX = coords.x * cellSize // gets the current x position (in pixels) in screen space
//        val myY = coords.y * cellSize // gets the current y position (in pixels) in screen space
        val coords: Location = state["coords"]
        val cellSize: Float = game.gameState["cellSize"]
        val myX = coords.x * cellSize
        val myY = coords.y * cellSize

        canvas.translate(myX, myY)
        paint.color = Color.rgb(50f, 45f, 15f)
        canvas.drawRect(0f, 0f, cellSize, cellSize, paint)
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas.drawRect(0f, 0f, cellSize, cellSize, paint)
        canvas.translate(cellSize/2f, cellSize/2f)
        canvas.rotate(45f)
        paint.style = Paint.Style.FILL
        paint.color = Color.DKGRAY
        canvas.drawRect(-50f, -50f, 50f, 50f, paint)
        canvas.rotate(-45f)
        canvas.drawRect(cellSize / 4f,cellSize / 4f, cellSize/2f, cellSize/2f, paint)

    }
}