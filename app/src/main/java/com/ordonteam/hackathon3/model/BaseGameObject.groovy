package com.ordonteam.hackathon3.model

import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileStatic

@CompileStatic
abstract class BaseGameObject {

    Dimension location

    MoveDirection move() {}

    void draw(ScaledCanvas canvas) {}

    void updateLocation(){}

}
