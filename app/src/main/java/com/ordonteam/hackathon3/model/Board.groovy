package com.ordonteam.hackathon3.model

import com.ordonteam.hackathon3.view.GameDrawable
import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.Canonical
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

import static Dimension.xy

@CompileStatic
class Board implements GameDrawable, Serializable {
    static final long serialVersionUID = 42L

    long hashCode
    Dimension size
    List<Wall> walls = new ArrayList<>()

    @Override
    void draw(ScaledCanvas canvas) {
        walls.each {
            it.draw(canvas)
        }
    }

    static Board generateBoard(int playerNumber) {
        return generateBoard(Dimension.xy(20, 20))
    }

//  TODO: remove compile dynamic
    @CompileDynamic
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
        board.walls.add(new Wall(xy(new Random().nextInt(size.x),new Random().nextInt(size.y))))
        board.hashCode = new Random().nextLong()
        return board
    }

    @CompileDynamic
    static Board chooseBoard(Board firstBoard, Board secondBoard) {
        if (!firstBoard) return secondBoard
        if (!secondBoard) return firstBoard
        return Collections.min([firstBoard, secondBoard], { Board b1, Board b2 ->
            return b1.hashCode - b2.hashCode
        })
    }
}
