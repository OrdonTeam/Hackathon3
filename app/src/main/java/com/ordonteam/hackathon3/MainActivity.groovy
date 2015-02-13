package com.ordonteam.hackathon3

import android.os.Bundle
import android.widget.TextView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends LoginActivity {

    @InjectView(R.id.textView)
    TextView text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        SwissKnife.inject(this)

        text.setText('Hello Groovy')
    }

    @Override
    void onConnected(Bundle bundle) {
        text.setText('Connected')
    }

    @Override
    void onConnectFailed(int errorCode) {
        text.setText("onConnectFailed Code = $errorCode")
    }

    @Override
    void onNotSignedIn(int errorCode) {
        text.setText("onNotSignedIn Code = $errorCode")
    }
}