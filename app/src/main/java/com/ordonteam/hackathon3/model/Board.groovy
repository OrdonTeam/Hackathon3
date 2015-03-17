package com.ordonteam.hackathon3.model
import com.ordonteam.hackathon3.view.GameDrawable
import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

import static com.ordonteam.hackathon3.model.Dimension.xy

@CompileStatic
class Board implements GameDrawable, Serializable, Peristable {
    static final long serialVersionUID = 42L

    long hashCode
    Dimension size
    List<Wall> insideWalls = new ArrayList<>()
    transient List<Wall> outsideWalls

    List<Wall> getWalls(){
        def list = []
        list.addAll(outsideWalls)
        list.addAll(insideWalls)
        return list
    }

    @Override
    void draw(ScaledCanvas canvas) {
        walls.each {
            it.draw(canvas)
        }
    }

    static Board generateBoard(int playerNumber) {
        return generateBoard(xy(20, 20))
    }

//  TODO: remove compile dynamic
    @CompileDynamic
    static Board generateBoard(Dimension size) {
        Board board = new Board(size: size)
        board.outsideWalls = generateOutsideWalls()
        board.insideWalls.add(new Wall(xy(new Random().nextInt(size.x), new Random().nextInt(size.y))))
        board.hashCode = new Random().nextLong()
        return board
    }

    @CompileDynamic
    private static List<Wall> generateOutsideWalls() {
        def ySize = 20
        def xSize = 20
        List<Wall> outsideWalls = []
        (0..<xSize).each { int x ->
            outsideWalls.add(new Wall(xy(x, 0)))
            outsideWalls.add(new Wall(xy(x, ySize - 1)))
        }
        (1..<(ySize - 1)).each { int y ->
            outsideWalls.add(new Wall(xy(0, y)))
            outsideWalls.add(new Wall(xy(xSize - 1, y)))
        }
        return outsideWalls
    }

    @CompileDynamic
    static Board chooseBoard(Board firstBoard, Board secondBoard) {
        if (!firstBoard) return secondBoard
        if (!secondBoard) return firstBoard
        return firstBoard.hashCode > secondBoard.hashCode ? firstBoard : secondBoard
    }

    byte[] persist() {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        byteOutputStream.withObjectOutputStream { ObjectOutputStream stream ->
            stream.writeObject(this)
        }
        return byteOutputStream.toByteArray()
    }

    @Override
    Peristable unpersist() {
        outsideWalls = generateOutsideWalls()
        return this
    }
}
