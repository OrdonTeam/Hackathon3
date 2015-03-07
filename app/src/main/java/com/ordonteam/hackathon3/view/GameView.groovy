package com.ordonteam.hackathon3.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout
import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class GameView extends LinearLayout {
    private GameObjects gameObjects

    GameView(Context context) {
        super(context)
    }

    GameView(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }

    void setGameObjects(GameObjects gameObjects) {
        this.gameObjects = gameObjects
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas)
        gameObjects?.drawAll(canvas)
    }
}
