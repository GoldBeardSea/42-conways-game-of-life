package com.gbbeard.conwaysgame;

public class Environment {

    private int SIZE = 60;

    private float x0;
    private float y0;
    private float x1 = x0 + SIZE;
    private float y1 = y0 + SIZE;

    private int color;


    public Environment(float x0, float y0, float x1, float y1) {

    }

    public boolean contains(float xx, float yy) {
        float ex = (this.x0 - xx) * (this.x0 - xx);
        float ey = (this.y0 - yy) * (this.y0 - yy);


        double inside = Math.sqrt(ex + ey);

        return inside < SIZE;
    }
}