package com.ordonteam.hackathon3.model

import groovy.transform.CompileStatic

@CompileStatic
interface Peristable {
    byte[] persist()
    Peristable unpersist()
}