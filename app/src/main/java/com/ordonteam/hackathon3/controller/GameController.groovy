package com.ordonteam.hackathon3.controller

import android.util.Log
import android.view.View
import com.ordonteam.hackathon3.model.BaseGameObject
import com.ordonteam.hackathon3.model.GameObjects
import com.ordonteam.hackathon3.model.MoveDirection
import com.ordonteam.hackathon3.utils.ThreadUtil
import com.ordonteam.hackathon3.view.common.Dimension
import groovy.transform.CompileStatic

import static com.ordonteam.hackathon3.utils.ThreadUtil.startInteruptableThread
import static com.ordonteam.hackathon3.utils.ThreadUtil.startThread

@CompileStatic
class GameController {
    GameObjects gameObjects
    private Thread thread
    private ViewController viewController

    GameController(GameObjects gameObjects) {
        this.gameObjects = gameObjects
    }

    void setViewController(ViewController viewController) {
        this.viewController = viewController
    }

    void moveAll() {
        gameObjects = gameObjects.moveAll()
        viewController.newObjects(gameObjects)
    }

    void onResume() {
        thread = startInteruptableThread({
            while (true) {
                moveAll()
                Log.e("move", "all")
                Thread.sleep(1000)
            }
        })
    }

    void onPause() {
        thread.interrupt()
    }
}
