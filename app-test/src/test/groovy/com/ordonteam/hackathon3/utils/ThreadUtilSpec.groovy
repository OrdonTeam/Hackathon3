package com.ordonteam.hackathon3.utils

import spock.lang.Specification

import java.util.concurrent.ConcurrentHashMap

class ThreadUtilSpec extends Specification{

    def "should do it"(){
        given:
        ArrayList<Long> time = new ArrayList<>()

        when:
        Thread thread = ThreadUtil.startInInfiniteLoop(100){
                time.add(System.currentTimeMillis())
                Thread.sleep(67)
        }
        Thread.sleep(650)
        thread.interrupt()
        Thread.sleep(2000)

        then:
        (0..5).every {
            time[it+1] - time[it] < 110
        }
        (0..5).sum{
            time[it+1] - time[it] - 100
        } < 30
        println(time)
    }

    def "Should we iterate over hashmap when someone is changing element"(){
        given:
        Map<String, String> someMap = new ConcurrentHashMap<>()

        someMap.put("Player1", "State1")
        someMap.put("Player2","State2")
        someMap.put("Player3","State3")

        and:
        def foreverOnceIn = ThreadUtil.startInInfiniteLoop(0) {
            someMap.put("Player1", "State1")
            someMap.put("Player2", "State2")
            someMap.put("Player3", "State3")
        }
        Thread.sleep(100)

        when:
        def collect = someMap.values().collect {
            Thread.sleep(100)
            it
        }

        then:
        collect.containsAll('State1','State2','State3')

        cleanup:
        foreverOnceIn.interrupt()

    }
}
