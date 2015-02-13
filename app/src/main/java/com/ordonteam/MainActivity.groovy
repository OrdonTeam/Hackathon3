package com.ordonteam

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import groovy.transform.CompileStatic

@CompileStatic
class MainActivity extends Activity {

    @InjectView(R.id.textView)
    TextView text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        SwissKnife.inject(this)

        text.setText('Hello Groovy')
    }
}