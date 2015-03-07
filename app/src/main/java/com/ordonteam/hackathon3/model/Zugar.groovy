package com.ordonteam.hackathon3.model

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.GamePaint
import groovy.transform.CompileStatic

@CompileStatic
class Zugar extends BaseGameObject {

    Paint paint = GamePaint.forColor(Color.GREEN)

    Zugar(Dimension location) {
        super(location)
    }

    @Override
    BaseGameObject withNewLocation(MoveDirection moveDirection) {
        return new Zugar(location.to(moveDirection))
    }
}
