package com.ordonteam.hackathon3

import com.ordonteam.hackathon3.model.Board
import com.ordonteam.hackathon3.view.common.Dimension
import pl.polidea.robospock.RoboSpecification

class BoardSpec extends RoboSpecification{

    def "All players should have the same board on startup"(){
        given:
        def b1 = Board.generateBoard(new Dimension(100, 100))
        def b2 = Board.generateBoard(new Dimension(100, 100))


        expect:
        Board.chooseBoard(b1, b2) == Board.chooseBoard(b2, b1)
    }
}
