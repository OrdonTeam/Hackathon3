package com.ordonteam.hackathon3.model

import android.graphics.Canvas
import groovy.transform.CompileStatic

@CompileStatic
class GameObjects {
    Set<BaseGameObject> gameObjects = new HashSet<>()

    void moveAll() {
        gameObjects.each {
            it.move()
        }
    }

    void drawAll(Canvas canvas) {
        gameObjects.each {
            it.draw(canvas)
        }
    }

    void add(BaseGameObject object) {
        gameObjects.add(object)
    }
}
