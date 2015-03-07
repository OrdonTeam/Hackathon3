package com.ordonteam.hackathon3

import android.app.Activity
import android.os.Bundle
import com.ordonteam.hackathon3.model.*
import groovy.transform.CompileStatic

@CompileStatic
class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        GameObjects objects = new GameObjects()
        objects.add(new Zugar())
        objects.add(new Snorg())
        objects.add(new Fluppet())
        objects.add(new Toxifera())
        objects.add(new Wall())
    }
}
