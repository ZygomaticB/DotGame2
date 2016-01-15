package com.example.trh.dotgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.example.trh.dotgame.Tools.DotPlacingTool;
import com.example.trh.dotgame.Tools.DraggingTool;
import com.example.trh.dotgame.Tools.DrawingTool;
import com.example.trh.dotgame.Tools.EraserTool;
import com.example.trh.dotgame.Tools.Tool;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by trh on 12/19/15.
 */
public class GameView extends View{

    private List<Tool> tools = new LinkedList<Tool>();
    private List<Dot> dots;
    private Bitmap farrow;
    private Bitmap barrow;
    private int screenW;
    private int screenH;
    private int movingDot = -1;


    public GameView(Context context) {
        super(context);
        dots = new LinkedList<Dot>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Dot dot : dots) {
            canvas.drawCircle(dot.getxPosition(), dot.getyPosition(), dot.getRadius(), dot.getColor());
        }
        canvas.drawBitmap(tools.get(0).getImage(), screenW/2-60, 0, null);
        canvas.drawBitmap(barrow, 0, 0, null);
        canvas.drawBitmap(farrow, screenW-farrow.getWidth(), 0, null);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
        farrow = BitmapFactory.decodeResource(getResources(), R.drawable.f_arrow);
        barrow = BitmapFactory.decodeResource(getResources(), R.drawable.b_arrow);
        tools.add(new EraserTool(this));
        tools.add(new DraggingTool(this));
        tools.add(new DotPlacingTool(this));
        tools.add(new DrawingTool(this));
    }

    public void placeDot(int x, int y, int radius, int color) {
        dots.add(new Dot(color, x, y, radius, false));
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (eventaction) {

            case MotionEvent.ACTION_UP:
                if (x < barrow.getWidth() && y < barrow.getHeight()) {
                    previousTool();
                } else if (x > screenW-farrow.getWidth() && y < farrow.getHeight()) {
                    nextTool();
                } else
                tools.get(0).actionUp(x, y);
                movingDot = -1;
                break;
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i < dots.size(); i++){
                    if (withinDot(x, y, dots.get(i))){
                        movingDot = i;
                    }
                }
            case MotionEvent.ACTION_MOVE:
                if (tools.get(0) instanceof DraggingTool && movingDot > -1) {
                    dots.get(movingDot).setxPosition(x);
                    dots.get(movingDot).setyPosition(y);
                }
                if (tools.get(0) instanceof DrawingTool) {
                    DrawingTool tool = (DrawingTool) tools.get(0);
                    placeDot(x, y, tool.getDotSize(), tool.getColor());
                }
                break;
        }
        return true;
    }

    private void nextTool() {
        Collections.rotate(tools, -1);
    }

    private void previousTool() {
        Collections.rotate(tools, 1);
    }

    private boolean withinDot(int x, int y, Dot dot) {
        int dotX = dot.getxPosition();
        int dotY = dot.getyPosition();
        int radius = dot.getRadius();
        int xMin = dotX - radius;
        int xMax = dotX + radius;
        int yMin = dotY - radius;
        int yMax = dotY + radius;
        if ((xMin < x) && (xMax > x) && (yMin < y) && (yMax > y))
            return true;
        else
            return false;
    }

    public void removeDot(int x, int y) {
        for (int i = 0; i < dots.size(); i++) {
            if (withinDot(x, y, dots.get(i))) {
                dots.remove(i);
            }
        }
    }

    public void removeDots(int x, int y, int size) {
        for (Iterator<Dot> dIt = dots.iterator(); dIt.hasNext();) {
            Dot d = dIt.next();
            if (d.getxPosition() > x-size && d.getxPosition() < x+size &&
                    d.getyPosition() < y+size && d.getyPosition() > y-size){
                dIt.remove();
            }
        }
    }
}
