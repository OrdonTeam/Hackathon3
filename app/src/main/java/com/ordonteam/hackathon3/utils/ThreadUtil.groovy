package com.ordonteam.hackathon3.utils

import groovy.transform.CompileStatic

import static java.lang.Math.max
import static java.lang.Thread.sleep

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

    static void foreverOnceIn(int milis, Closure closure){
        while (true){
            long start = System.currentTimeMillis()
            closure()
            long duration = System.currentTimeMillis() - start
            sleep(max(milis-duration,0))
        }
    }

    static Thread startInInfiniteLoop(int milis, Closure closure) {
        return startInteruptableThread{
            foreverOnceIn(milis,closure)
        }
    }
}
