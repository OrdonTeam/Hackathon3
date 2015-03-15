package com.ordonteam.hackathon3.model

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.GamePaint
import groovy.transform.CompileStatic

@CompileStatic
class Snorg extends BaseGameObject implements Serializable {
    static final long serialVersionUID = 42L

    Paint paint = GamePaint.forColor(Color.RED)

    Snorg(Dimension location) {
        super(location)
    }

    @Override
    MoveDirection move() {
        return MoveDirection.RIGHT
    }

    @Override
    BaseGameObject withNewLocation(MoveDirection moveDirection) {
        return new Snorg(location.to(moveDirection))
    }
}
