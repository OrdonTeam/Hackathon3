package com.ordonteam.hackathon3.view.common

import com.ordonteam.hackathon3.model.MoveDirection
import groovy.transform.Canonical
import groovy.transform.CompileStatic;

@CompileStatic
@Canonical
public class Dimension {
    final int width
    final int height

    Dimension(int width, int height) {
        this.height = height
        this.width = width
    }

    static Dimension xy(int x, int y) {
        return new Dimension(x, y)
    }

    Dimension to(MoveDirection moveDirection) {
        return new Dimension(width+moveDirection.x,height+moveDirection.y)
    }
}
