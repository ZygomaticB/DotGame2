package com.example.trh.dotgame;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.Map;

/**
 * Created by trh on 12/19/15.
 */
public class Dot {

    private Paint color;
    private int xPosition;
    private int yPosition;
    private int radius;
    private boolean dragable;
    private int touchCount = 0;

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

    public void setColor(int alpha, int red, int blue, int green) {
        color.setColor(Color.argb(alpha, red, blue, green));
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

    public void setTouchCount(int touchCount) {
        this.touchCount = touchCount;
    }

    public int getTouchCount() {
        return touchCount;
    }

    public boolean isDragable() { return dragable; }

}
