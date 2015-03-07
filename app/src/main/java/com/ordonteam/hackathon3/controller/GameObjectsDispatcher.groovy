package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class GameObjectsDispatcher {

    GameObjectsConsumer gameController
    GameObjectsConsumer viewController
    GameObjectsConsumer networkController

    void fromNetwork(GameObjects gameObjects) {
        gameController.newObjects(gameObjects)
        viewController.newObjects(gameObjects)
    }

    void fromGameController(GameObjects gameObjects){
        viewController.newObjects(gameObjects)
        networkController.newObjects(gameObjects)
    }

}
