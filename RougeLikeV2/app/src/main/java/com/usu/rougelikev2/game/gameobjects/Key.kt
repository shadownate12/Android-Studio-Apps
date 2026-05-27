package com.usu.rougelikev2.game.gameobjects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject
import com.usu.rougelikev2.game.gameengine.Location


class Key(game: Game?) : GameObject(game!!) {
    override fun render(canvas: Canvas, paint: Paint) {
//        things you can do in this render method for reference.
//        val coords: Location = state["coords"] // gets the location of the object in the grid
//        val cellSize: Int = game.gameState["cellSize"] // gets the size of each cell in the game
//        val myX = coords.x * cellSize // gets the current x position (in pixels) in screen space
//        val myY = coords.y * cellSize // gets the current y position (in pixels) in screen space
//        val isActive: Boolean = state.get("active") // get whether the key is active or not (not active means the player already picked it up)
        val isActive: Boolean = state["active"]
        if (!isActive) return
        val coords: Location = state["coords"]
        val cellSize: Int = game.gameState["cellSize"]
        val myX = coords.x * cellSize
        val myY = coords.y * cellSize

        canvas.translate(myX, myY)
        paint.color = Color.YELLOW
        canvas.drawCircle((cellSize/3).toFloat(), (cellSize - cellSize/3).toFloat(), cellSize/4.toFloat(), paint)
        paint.color = Color.DKGRAY
        canvas.drawCircle((cellSize/3).toFloat(), (cellSize - cellSize/3).toFloat(), (cellSize/4) - 20f, paint)
        canvas.rotate(-45f)
        paint.color = Color.YELLOW
        canvas.drawRect(cellSize/2.toFloat()-10f, cellSize -40f ,cellSize/3 - 70f, cellSize-60f, paint)
        paint.color = Color.BLACK
        canvas.rotate(45f)
        canvas.drawRect(cellSize - 40f, 20f, cellSize - 20f, 40f, paint)

    }

    init {
        state["active"] = true
    }
}