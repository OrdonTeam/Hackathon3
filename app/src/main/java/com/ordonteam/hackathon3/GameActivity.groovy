package com.ordonteam.hackathon3

import android.app.Activity
import android.os.Bundle
import groovy.transform.CompileStatic

@CompileStatic
class GameActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)
    }
}