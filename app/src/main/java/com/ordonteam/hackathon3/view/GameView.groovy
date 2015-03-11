package com.ordonteam.hackathon3.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout
import com.ordonteam.hackathon3.model.Board
import com.ordonteam.hackathon3.model.GameObjects
import com.ordonteam.hackathon3.view.common.Scale
import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileStatic

@CompileStatic
class GameView extends LinearLayout {
    private GameObjects gameObjects
    private GroovyLock lock = new GroovyLock()
    Board board

    GameView(Context context) {
        super(context)
    }

    GameView(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }

    void updateGameObjects(GameObjects gameObjects) {
        lock.withLock {
            this.gameObjects = gameObjects
        }
        postInvalidate()
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas)
        ScaledCanvas scaledCanvas = new ScaledCanvas(canvas, new Scale(20, 20))
        board?.draw(scaledCanvas)
        lock.withLock {
            gameObjects?.drawAll(scaledCanvas)
        }
    }
}
