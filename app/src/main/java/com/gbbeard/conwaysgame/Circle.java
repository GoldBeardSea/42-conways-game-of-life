package com.gbbeard.conwaysgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle {
    private float xx;
    private float yy;
    private float radius;
    private int color;
    private int value;
    private final int GREEN = Color.rgb(0, 255, 0);

    public Circle(float xx, float yy, float radius, int color, int value) {
        this.xx = xx;
        this.yy = yy;
        this.radius = radius;
        this.color = color;
        this.value = value;
    }

    public void setX(float xx) {
        this.xx = xx;
    }

    public void setY(float yy) {
        this.yy = yy;
    }

    public float getX() {
        return this.xx;
    }

    public int getValue() {
        return this.value;
    }

    public int setColor() {
        return this.color = GREEN;
    }

    public void draw(Canvas canvas) {
        Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
        brush.setColor(this.color);
        canvas.drawCircle(this.xx, this.yy, this.radius, brush);
    }

    public void drawSquare(Canvas canvas) {
        Paint myPaint = new Paint();
        myPaint.setColor(Color.rgb(0, 0, 0));
        myPaint.setStrokeWidth(10);
        canvas.drawRect(100, 100, 200, 200, myPaint);
    }

    public boolean contains(float xx, float yy) {
        float dx = this.xx - xx;
        float dy = this.yy - yy;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < this.radius;
    }
}
