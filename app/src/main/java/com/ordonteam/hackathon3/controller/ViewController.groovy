package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.Board
import com.ordonteam.hackathon3.model.GameObjects
import com.ordonteam.hackathon3.view.GameView
import groovy.transform.CompileStatic

@CompileStatic
class ViewController implements GameObjectsConsumer{
    private GameView gameView

    void newObjects(String participantId, GameObjects gameObjects) {
        gameView.updateGameObjects(participantId, gameObjects)
    }

    void setView(GameView gameView) {
        this.gameView = gameView
    }

    void newBoard(Board newBoard) {
        gameView.board = newBoard
    }
}
