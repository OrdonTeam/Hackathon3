package com.ordonteam.hackathon3.utils

import groovy.transform.CompileStatic

@CompileStatic
class ThreadUtil {
    static Thread startThread(Runnable runnable) {
        Thread thread = new Thread(runnable)
        thread.start()
        return thread
    }

    static Thread startInteruptableThread(Runnable runnable) {
        return startThread({
            try{
                runnable.run()
            }catch (InterruptedException e){
                //Ok, ok, do nothing
            }
        })
    }
}
