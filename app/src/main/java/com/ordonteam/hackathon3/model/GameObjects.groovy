package com.ordonteam.hackathon3.model

import android.graphics.Canvas
import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileStatic

@CompileStatic
class GameObjects {
    Set<BaseGameObject> gameObjects = new HashSet<>()

    void moveAll() {
        gameObjects.each {
            it.move()
        }
    }

    void drawAll(ScaledCanvas canvas) {
        gameObjects.each {
            it.draw(canvas)
        }
    }

    void add(BaseGameObject object) {
        gameObjects.add(object)
    }
}
