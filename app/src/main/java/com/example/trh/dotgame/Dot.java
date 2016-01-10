package com.example.trh.dotgame;

import android.graphics.Paint;

/**
 * Created by trh on 12/19/15.
 */
public class Dot {

    private Paint color;
    private int xPosition;
    private int yPosition;
    private int radius;
    private boolean dragable;

    public Dot(int color, int x, int y, int radius, boolean dragable) {
        this.color = new Paint();
        this.color.setColor(color);
        xPosition = x;
        yPosition = y;
        this.radius = radius;
        this.dragable = dragable;
    }

    public Paint getColor() {
        return color;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getRadius() {
        return radius;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
