package com.ordonteam.hackathon3.model

import groovy.transform.CompileStatic

@CompileStatic
class GameObjects {
    Set<BaseGameObject> gameObjects = new HashSet<>()

    void moveAll() {
        gameObjects.each {
            it.move()
        }
    }

    void drawAll() {
        gameObjects.each {
            it.draw()
        }
    }

    void add(BaseGameObject object) {
        gameObjects.add(object)
    }
}
