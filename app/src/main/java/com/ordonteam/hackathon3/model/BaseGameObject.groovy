package com.ordonteam.hackathon3.model

import com.ordonteam.hackathon3.view.GameDrawable
import groovy.transform.CompileStatic

@CompileStatic
abstract class BaseGameObject implements GameDrawable {

    void move(){}
}
