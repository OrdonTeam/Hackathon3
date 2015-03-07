package com.ordonteam.hackathon3.view.utils

import android.graphics.Canvas
import com.ordonteam.hackathon3.view.common.Scale

/**
 * Created by ghost on 07.03.15.
 */
class ScaledCanvas {

    Scale scale
    Canvas canvas

    ScaledCanvas(Canvas canvas, Scale scale) {
        this.canvas = canvas
        this.scale = scale
    }
}
