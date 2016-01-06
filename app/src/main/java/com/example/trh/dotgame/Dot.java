package com.example.trh.dotgame;

/**
 * Created by trh on 12/19/15.
 */
public class Dot {

    private int color;
    private int xPosition;
    private int yPosition;
    private int radius;
    private boolean dragable;

    public Dot(int color, int x, int y, int radius, boolean dragable) {
        this.color = color;
        xPosition = x;
        yPosition = y;
        this.radius = radius;
        this.dragable = dragable;
    }

    public int getColor() {
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
