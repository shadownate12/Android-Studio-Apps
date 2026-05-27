package com.usu.rougelikev2.game.gameobjects

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.usu.rougelikev2.game.gameengine.Game
import com.usu.rougelikev2.game.gameengine.GameObject


class GameOverMessage(game: Game?) : GameObject(game!!) {
    override fun render(canvas: Canvas, paint: Paint) {
        // this object is a little different than the others as is doesn't have a position inherently.
        // its position is determined at render time.
        // here are some of the things that will be useful for you.
        // game.height // get the height of the game
        // game.width; // get the width of the game
        val isPlaying: Boolean = game.gameState["playing"]
        if (isPlaying) return
        paint.color = Color.RED
        paint.textSize = 100f
        canvas.drawText("GAME OVER", 100f, game.height / 2, paint)
        paint.color = Color.RED
        canvas.drawText("GAME OVER", 90f, game.height / 4, paint)
        paint.color = Color.CYAN
        canvas.drawText("TRY AGAIN?", 300f, game.height- 70f, paint)
        canvas.translate(game.height / 4, game.height - game.height/8)

        canvas.rotate(45f)
        canvas.drawRect(-80f, 20f, 20f, -80f, paint)
        canvas.rotate(90f)
        canvas.drawRect(-80f, 0f, 20f, -100f, paint)
        canvas.rotate(180f)
        canvas.drawRect(-20f, 0f, 80f, -160f, paint)
        canvas.rotate(90f)
        canvas.drawRect(40f, -160f, -60f, 100f, paint)


    }
}