package com.ordonteam.hackathon3.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import groovy.transform.CompileStatic

@CompileStatic
class GameView extends LinearLayout{
    GameView(Context context) {
        super(context)
    }

    GameView(Context context, AttributeSet attrs) {
        super(context, attrs)
    }

    GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle)
    }
}
