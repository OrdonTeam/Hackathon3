package com.ordonteam.hackathon3.model

import android.graphics.Color
import android.graphics.Paint
import com.ordonteam.hackathon3.view.PlayerPadView
import com.ordonteam.hackathon3.view.common.Dimension
import com.ordonteam.hackathon3.view.utils.GamePaint
import groovy.transform.CompileStatic

@CompileStatic
class UserBot extends BaseGameObject{

    Paint paint = GamePaint.forColor(Color.CYAN)
    private PlayerPadView playerPadView

    UserBot(Dimension location, PlayerPadView playerPadView) {
        super(location)
        this.playerPadView = playerPadView
    }

    @Override
    MoveDirection move() {
        return playerPadView.getCurrentInclination()
    }

    @Override
    BaseGameObject withNewLocation(MoveDirection moveDirection) {
        return new UserBot(location.to(moveDirection),playerPadView)
    }
}
