package com.ordonteam.hackathon3.model

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.GamePaint
import groovy.transform.CompileStatic

@CompileStatic
class Toxifera extends BaseGameObject {

    Paint paint = GamePaint.forColor(Color.YELLOW)

    Toxifera(Dimension location) {
        super(location)
    }

    @Override
    Paint getPaint() {
        return paint
    }
}
