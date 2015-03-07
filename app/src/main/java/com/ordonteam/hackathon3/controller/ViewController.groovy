package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.GameObjects
import com.ordonteam.hackathon3.view.GameView
import groovy.transform.CompileStatic

@CompileStatic
class ViewController {
    GameObjects gameObjects
    private GameView gameView

    ViewController(GameObjects gameObjects) {
        this.gameObjects = gameObjects
    }

    void newObjects(GameObjects gameObjects) {
        gameView.updateGameObjects(gameObjects)
    }

    void setView(GameView gameView) {
        this.gameView = gameView
    }
}
