package com.ordonteam.hackathon3.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.ordonteam.hackathon3.model.MoveDirection
import groovy.transform.CompileStatic

@CompileStatic
class PlayerPadView extends LinearLayout{
    PlayerPadView(Context context) {
        super(context)
    }

    PlayerPadView(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    PlayerPadView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }

    MoveDirection getCurrentInclination() {
        return MoveDirection.DOWN
    }
}