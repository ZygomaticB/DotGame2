package com.example.trh.dotgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trh on 12/19/15.
 */
public class GameView extends View {

    private Tool currentTool;
    private List<Tool> tools = new ArrayList<Tool>();
    private List<Dot> dots;
    private Bitmap currentToolImage;
    private int screenW;
    private int screenH;


    public GameView(Context context) {
        super(context);
        dots = new ArrayList<Dot>();
        tools.add(new DotPlacingTool(this));
        tools.add(new DraggingTool(this));
        currentTool = tools.get(0);
        currentToolImage = currentTool.getImage();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Dot dot : dots) {
            Paint color = new Paint();
            color.setColor(dot.getColor());
            canvas.drawCircle(dot.getxPosition(), dot.getyPosition(), dot.getRadius(), color);
        }

        canvas.drawBitmap(currentToolImage, screenW/2-60, 0, null);
        Bitmap barrow = BitmapFactory.decodeResource(getResources(), R.drawable.b_arrow);
        Bitmap farrow = BitmapFactory.decodeResource(getResources(), R.drawable.f_arrow);
        canvas.drawBitmap(barrow, 0, 0, null);
        canvas.drawBitmap(farrow, screenW-farrow.getWidth(), 0, null);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }

    public void placeDot(int x, int y) {
        dots.add(new Dot(Color.BLUE, x, y, 100, false));
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int x = (int)event.getX();
        int y = (int)event.getY();
        currentTool.onTouchEvent(event);
        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                if (x < 60 && y < 60) {
                    previousTool();
                }
                else if (x > screenW-60 && y < 60) {
                    nextTool();
                }
                break;
        }

        return true;
    }

    private void nextTool() {
        Tool prevTool = currentTool;
        tools.remove(0);
        tools.add(prevTool);
        currentTool = tools.get(0);
        currentToolImage = currentTool.getImage();
    }

    private void previousTool() {
        int prev = tools.size()-1;
        currentTool = tools.get(prev);
        tools.remove(prev);
        tools.add(currentTool);
        currentToolImage = currentTool.getImage();
    }

    private boolean withInSelector(int x, int y) {
        int width = currentToolImage.getWidth();
        int height = currentToolImage.getHeight();
        if ((x > 0) && (x < width) && (y > 0) && (y < height)) {
            return true;
        }
        else
            return false;
    }


    public Dot dotAtXY(int x, int y) {
        Dot retDot = null;
        for (Dot dot : dots) {
            if (withinDot(x, y, dot)) {
                retDot = dot;
            }
        }
        return retDot;
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
}
