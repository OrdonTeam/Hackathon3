package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class ViewController {
    GameObjects gameObjects

    ViewController(GameObjects gameObjects) {
        this.gameObjects = gameObjects
    }

    void drawAll() {
        gameObjects.drawAll()
    }
}
