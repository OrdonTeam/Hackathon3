package com.ordonteam.hackathon3.utils

import spock.lang.Specification

class ThreadUtilSpec extends Specification{

    def "should do it"(){
        given:
        ArrayList<Long> time = new ArrayList<>()

        when:
        Thread thread = ThreadUtil.startInteruptableThread {
            ThreadUtil.foreverOnceIn(100) {
                time.add(System.currentTimeMillis())
                Thread.sleep(67)
            }
        }
        Thread.sleep(650)
        thread.interrupt()
        Thread.sleep(2000)

        then:
        time.size() == 7
        (0..5).every {
            time[it+1] - time[it] < 110
        }
        (0..5).sum{
            time[it+1] - time[it] - 100
        } < 30
        println(time)
    }
}
