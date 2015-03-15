package com.ordonteam.hackathon3

import android.app.Activity
import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
import com.ordonteam.hackathon3.controller.GameController
import com.ordonteam.hackathon3.controller.GameObjectsDispatcher
import com.ordonteam.hackathon3.controller.NetworkController
import com.ordonteam.hackathon3.controller.ViewController
import com.ordonteam.hackathon3.model.*
import com.ordonteam.hackathon3.view.GameView
import com.ordonteam.hackathon3.view.PlayerPadView
import groovy.transform.CompileStatic

import static com.ordonteam.hackathon3.view.common.Dimension.xy

@CompileStatic
class GameActivity extends RoomActivity {

    @InjectView(R.id.game_view)
    GameView gameView
    @InjectView(R.id.player_pad_view)
    PlayerPadView playerPadView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        SwissKnife.inject(this)
    }

    @Override
    void startGame() {
        Board.generateBoard(3)
    }

    @Override
    void onConnectFailed(int i) {

    }

    @Override
    void onNotSignedIn(int errorCode) {

    }

    @Override
    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {

    }

    @Override
    void onRoomCreationFailure(int statusCode) {
        finish()
    }
}