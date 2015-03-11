package com.ordonteam.hackathon3.model

import android.graphics.Paint
import com.ordonteam.hackathon3.view.GameDrawable
import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.ScaledCanvas
import groovy.transform.CompileStatic

@CompileStatic
abstract class BaseGameObject implements GameDrawable{

    final Dimension location

    BaseGameObject(Dimension location) {
        this.location = location
    }

    MoveDirection move() {
        return MoveDirection.NOWHERE
    }
    
    void draw(ScaledCanvas canvas) {
        canvas.drawRectangle(location,getPaint())
    }

    abstract BaseGameObject withNewLocation(MoveDirection moveDirection);

    abstract Paint getPaint()
}
