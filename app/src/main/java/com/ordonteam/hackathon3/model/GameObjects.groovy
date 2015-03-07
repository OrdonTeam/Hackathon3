package com.ordonteam.hackathon3.model

import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileStatic

@CompileStatic
class GameObjects {
    final int turn
    final Set<BaseGameObject> gameObjects

    GameObjects(Set<BaseGameObject> gameObjects) {
        this(0,gameObjects)
    }

    GameObjects(int turn, Set<BaseGameObject> gameObjects) {
        this.turn = turn
        this.gameObjects = gameObjects
    }

    void drawAll(ScaledCanvas canvas) {
        gameObjects.each {
            it.draw(canvas)
        }
    }

    void add(BaseGameObject object) {
        gameObjects.add(object)
    }

    GameObjects moveAll() {

        Set<BaseGameObject> collect = gameObjects.collect { BaseGameObject gameObject ->
            MoveDirection direction = gameObject.move()
            BaseGameObject find = gameObjects.find {
                it.location == gameObject.location.to(direction)
            }
            if (find) {
                return gameObject
            } else {
                return gameObject.withNewLocation(direction)
            }
        } as Set
        return new GameObjects(turn+1,collect)
    }

}
