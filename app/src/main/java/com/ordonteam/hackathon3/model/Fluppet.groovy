package com.ordonteam.hackathon3.model

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.GamePaint
import groovy.transform.CompileStatic

@CompileStatic
class Fluppet extends BaseGameObject {

    Paint paint = GamePaint.forColor(Color.BLUE)

    Fluppet(Dimension location) {
        super(location)
    }

    @Override
    MoveDirection move() {
        return MoveDirection.RIGHT
    }

    @Override
    BaseGameObject withNewLocation(MoveDirection moveDirection) {
        return new Fluppet(location.to(moveDirection))
    }
}
