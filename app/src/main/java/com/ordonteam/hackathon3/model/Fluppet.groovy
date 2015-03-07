package com.ordonteam.hackathon3.model

import groovy.transform.CompileStatic

@CompileStatic
class Fluppet extends BaseGameObject {

    @Override
    MoveDirection move() {
        return MoveDirection.RIGHT
    }
}
