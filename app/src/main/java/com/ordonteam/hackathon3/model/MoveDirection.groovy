package com.ordonteam.hackathon3.model

import groovy.transform.CompileStatic

@CompileStatic
enum MoveDirection {
    UP(0,1),
    DOWN(0,-1),
    RIGHT(1,0),
    LEFT(-1,0),
    NOWHERE(0,0)

    final int x
    final int y

    MoveDirection(int x, int y) {
        this.x = x
        this.y = y
    }
}
