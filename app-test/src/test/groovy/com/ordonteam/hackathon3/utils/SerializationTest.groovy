package com.ordonteam.hackathon3.utils
import com.google.android.gms.games.multiplayer.Multiplayer
import com.ordonteam.hackathon3.controller.GameObjectsDispatcher
import com.ordonteam.hackathon3.model.Board
import pl.polidea.robospock.RoboSpecification

import static com.ordonteam.hackathon3.model.Board.generateBoard

class SerializationTest extends RoboSpecification{

    def "Sending object should not be bigger than 1400 bytes"() {
        given:
        def board = generateBoard(3)

        when:
        byte[] bytes = board.persist()

        then:
        bytes.length <= Multiplayer.MAX_UNRELIABLE_MESSAGE_LEN
    }

    def "persist and unpersist board"(){
        given:
        Board board = generateBoard(3)

        when:
        def unpersist = GameObjectsDispatcher.unpersist(board.persist()) as Board

        then:
        board.walls.size() == unpersist.walls.size()
    }

}
