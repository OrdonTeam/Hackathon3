package com.ordonteam.hackathon3.model

import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileStatic

@CompileStatic
abstract class BaseGameObject {

    void move() {}

    void draw(ScaledCanvas canvas) {}

}
