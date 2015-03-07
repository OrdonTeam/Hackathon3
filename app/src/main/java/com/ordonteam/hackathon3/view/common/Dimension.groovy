package com.ordonteam.hackathon3.view.common

import groovy.transform.Canonical
import groovy.transform.CompileStatic;

@CompileStatic
@Canonical
public class Dimension {
    final int width
    final int height

    Dimension(int width, int height){
        this.height = height
        this.width = width
    }

}
