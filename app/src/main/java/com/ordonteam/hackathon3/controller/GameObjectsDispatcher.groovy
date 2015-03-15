package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class GameObjectsDispatcher {

    GameObjectsConsumer gameController
    GameObjectsConsumer viewController
    GameObjectsConsumer networkController

    void fromNetwork(GameObjects gameObjects) {
        gameController.newObjects('participantId', gameObjects)
        viewController.newObjects('participantId', gameObjects)
    }

    void fromGameController(GameObjects gameObjects){
        viewController.newObjects('participantId', gameObjects)
        networkController.newObjects('participantId', gameObjects)
    }

}
