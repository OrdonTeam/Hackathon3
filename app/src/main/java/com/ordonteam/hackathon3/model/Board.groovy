package com.ordonteam.hackathon3.model

import com.ordonteam.hackathon3.view.GameDrawable
import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileStatic

import static com.ordonteam.hackathon3.view.common.Dimension.xy

@CompileStatic
class Board implements GameDrawable {

    Dimension size
    List<Wall> walls = new ArrayList<>()

    @Override
    void draw(ScaledCanvas canvas) {
        walls.each {
            it.draw(canvas)
        }
    }

    static Board generateBoard(Dimension size) {
        Board board = new Board(size: size)
        (0..<size.x).each { int x ->
            board.walls.add(new Wall(xy(x, 0)))
            board.walls.add(new Wall(xy(x, size.y - 1)))
        }
        (1..<(size.y - 1)).each { int y ->
            board.walls.add(new Wall(xy(0, y)))
            board.walls.add(new Wall(xy(size.x - 1, y)))
        }
        return board
    }
}
