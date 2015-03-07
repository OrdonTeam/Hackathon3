package com.ordonteam.hackathon3

import android.app.Activity
import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.ordonteam.hackathon3.controller.GameController
import com.ordonteam.hackathon3.model.*
import com.ordonteam.hackathon3.view.GameView
import com.ordonteam.hackathon3.view.PlayerPadView
import com.ordonteam.hackathon3.view.common.Dimension
import groovy.transform.CompileStatic

import static com.ordonteam.hackathon3.view.common.Dimension.xy

@CompileStatic
class GameActivity extends Activity {

    @InjectView(R.id.game_view)
    GameView gameView
    @InjectView(R.id.player_pad_view)
    PlayerPadView playerPadView
    private GameController gameController
    private GameObjects objects

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        SwissKnife.inject(this)

        objects = new GameObjects([
                new Zugar(xy(1, 1)), new Snorg(xy(2, 2)), new Fluppet(xy(3, 3)), new Toxifera(xy(4, 5)),
                new Wall(xy(6, 6)), new UserBot(xy(7, 7), playerPadView)
        ] as Set)

        gameView.setGameObjects(objects)

        gameController = new GameController(objects)
        gameController.setView(gameView)
    }

    @Override
    protected void onResume() {
        super.onResume()
        gameController.onResume()
    }

    @Override
    protected void onPause() {
        super.onPause()
        gameController.onPause()
    }
}
