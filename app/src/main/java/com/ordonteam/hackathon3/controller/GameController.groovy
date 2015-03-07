package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class GameController {
    GameObjects gameObjects

    GameController(GameObjects gameObjects) {
        this.gameObjects = gameObjects
    }

    void moveAll() {
        gameObjects.moveAll()
    }
}
