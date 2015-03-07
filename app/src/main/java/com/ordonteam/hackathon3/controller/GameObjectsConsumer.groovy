package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
interface GameObjectsConsumer {

    void newObjects(GameObjects gameObjects)

}
