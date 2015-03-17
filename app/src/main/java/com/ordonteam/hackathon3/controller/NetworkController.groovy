package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.Board
import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileStatic

@CompileStatic
class NetworkController implements GameObjectsConsumer{

    MessageSender sender

    NetworkController(MessageSender sender) {
        this.sender = sender
    }

    @Override
    void newObjects(String participantId, GameObjects gameObjects) {
        sender.sendUnreliableMessageToOthers(gameObjects.persist())
    }

    @Override
    void newBoard(Board board) {
        sender.sendUnreliableMessageToOthers(board.persist())
    }

}
