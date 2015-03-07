package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class GameObjectsDispatcher {

    GameController gameController
    ViewController viewController
    NetworkController networkController

    void fromNetwork(GameObjects gameObjects){
        gameController.gameObjects = gameObjects
        viewController.gameObjects = gameObjects
    }

    void fromGameController(GameObjects gameObjects){
        viewController.newObjects(gameObjects)
        networkController.newObjects(gameObjects)
    }
}
