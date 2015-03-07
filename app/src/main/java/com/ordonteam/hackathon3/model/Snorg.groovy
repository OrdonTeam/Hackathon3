package com.ordonteam.hackathon3.model

import groovy.transform.CompileStatic

@CompileStatic
class Snorg extends BaseGameObject {

    @Override
    MoveDirection move() {
        return MoveDirection.RIGHT
    }
}
