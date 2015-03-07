package com.ordonteam.hackathon3

import android.app.Activity
import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.ordonteam.hackathon3.controller.GameController
import com.ordonteam.hackathon3.model.*
import com.ordonteam.hackathon3.view.GameView
import groovy.transform.CompileStatic

@CompileStatic
class GameActivity extends Activity {

    @InjectView(R.id.game_view)
    GameView gameView
    private GameController gameController
    private GameObjects objects = new GameObjects()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        SwissKnife.inject(this)

        objects.add(new Zugar())
        objects.add(new Snorg())
        objects.add(new Fluppet())
        objects.add(new Toxifera())
        objects.add(new Wall())

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
