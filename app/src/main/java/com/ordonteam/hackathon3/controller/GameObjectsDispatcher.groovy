package com.ordonteam.hackathon3.controller

import com.ordonteam.hackathon3.model.Board
import com.ordonteam.hackathon3.model.GameObjects
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@CompileStatic
class GameObjectsDispatcher {

    GameObjectsConsumer gameController
    GameObjectsConsumer viewController
    GameObjectsConsumer networkController = new NetworkController()
    Board board // Can be null but who cares
    final String myParticipantId

    GameObjectsDispatcher(String myParticipantId) {
        this.myParticipantId = myParticipantId
    }

    void fromGameController(Board newBoard){
        board = Board.chooseBoard(board, newBoard)
        viewController.newBoard(board)
        networkController.newBoard(board)
    }

    void fromGameController(GameObjects gameObjects){
        viewController.newObjects(myParticipantId, gameObjects)
        networkController.newObjects(myParticipantId, gameObjects)
    }

    @CompileDynamic
    void fromNetwork(String participantId, byte[] bytes) {
        new ByteArrayInputStream(bytes).withObjectInputStream { ObjectInputStream stream ->
            def object = stream.readObject()
            fromNetwork(participantId, object)
        }
    }

    void fromNetwork(String participantId, Board newBoard) {
        board = Board.chooseBoard(board, newBoard)
        gameController.newBoard(board)
        viewController.newBoard(board)
    }

    void fromNetwork(String participantId, GameObjects gameObjects) {
        gameController.newObjects(participantId, gameObjects)
        viewController.newObjects(participantId, gameObjects)
    }
}
