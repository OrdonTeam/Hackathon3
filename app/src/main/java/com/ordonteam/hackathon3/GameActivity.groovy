package com.ordonteam.hackathon3

import android.app.Activity
import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
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
class GameActivity extends Activity {

    @InjectView(R.id.game_view)
    GameView gameView
    @InjectView(R.id.player_pad_view)
    PlayerPadView playerPadView
    private GameController gameController
    private GameObjects objects
    private ViewController viewController

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
        SwissKnife.inject(this)

        Board board = Board.generateBoard(xy(20, 20))
        gameView.board = board
        objects = GameObjects.generateObjects(board, playerPadView)
        gameView.updateGameObjects('participantId',objects)

        viewController = new ViewController(objects)
        viewController.setView(gameView)
        gameController = new GameController(objects)
        GameObjectsDispatcher dispatcher = createDispatcher()
        gameController.setDispather(dispatcher)
    }

    private GameObjectsDispatcher createDispatcher() {
        GameObjectsDispatcher dispatcher = new GameObjectsDispatcher()
        dispatcher.gameController = gameController
        dispatcher.viewController = viewController
        dispatcher.networkController = new NetworkController()
        return dispatcher
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
