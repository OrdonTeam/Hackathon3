package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.Board
import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class GameObjectsDispatcher {

    GameObjectsConsumer gameController
    GameObjectsConsumer viewController
    GameObjectsConsumer networkController = new NetworkController()

    void fromNetwork(GameObjects gameObjects) {
        gameController.newObjects('participantId', gameObjects)
        viewController.newObjects('participantId', gameObjects)
    }

    void fromNetwork(Board board) {

    }

    void fromGameController(GameObjects gameObjects){
        viewController.newObjects('participantId', gameObjects)
        networkController.newObjects('participantId', gameObjects)
    }

    void fromGameController(Board board){
        networkController.newBoard(board)
    }

    void fromNetwork(String participantId, byte[] bytes) {

    }
}
