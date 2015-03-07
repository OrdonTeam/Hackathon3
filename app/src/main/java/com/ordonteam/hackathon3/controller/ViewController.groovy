package com.ordonteam.hackathon3.controller

import android.graphics.Canvas
import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class ViewController {
    GameObjects gameObjects

    ViewController(GameObjects gameObjects) {
        this.gameObjects = gameObjects
    }

    void drawAll(Canvas canvas) {
        gameObjects.drawAll(canvas)
    }
}
