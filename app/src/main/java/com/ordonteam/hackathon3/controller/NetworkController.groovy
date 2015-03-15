package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.Board
import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class NetworkController implements GameObjectsConsumer{

    @Override
    void newObjects(String participantId, GameObjects gameObjects) {

    }

    @Override
    void newBoard(Board board) {

    }
}
