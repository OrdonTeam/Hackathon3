package com.ordonteam.hackathon3.controller

import android.util.Log
import android.view.View
import com.ordonteam.hackathon3.model.BaseGameObject
import com.ordonteam.hackathon3.model.GameObjects
import com.ordonteam.hackathon3.model.MoveDirection
import com.ordonteam.hackathon3.view.common.Dimension
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@CompileStatic
class GameController {
    GameObjects gameObjects
    private View view
    private Thread thread

    GameController(GameObjects gameObjects) {
        this.gameObjects = gameObjects
    }

    void moveAll() {
        gameObjects.gameObjects.each { BaseGameObject gameObject ->
            moveObject(gameObject.move(),gameObject.location) {
                gameObject.updateLocation()
            }
        }
        view?.postInvalidate()
    }

    void moveObject(MoveDirection moveDirection, Dimension location, Closure move) {
        move()
    }

    void setView(View view) {
        this.view = view
    }

    void onResume() {
        thread = new Thread({
            while (true) {
                moveAll()
                Log.e("move","all")
                Thread.sleep(1000)
            }
        })
        thread.start()
    }

    void onPause() {
        thread.interrupt()
    }
}
