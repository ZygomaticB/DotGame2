package com.example.trh.dotgame.Levels;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import com.example.trh.dotgame.Dot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trh on 1/11/16.
 */
public class Level4 extends Level {

    public Level4(Context context) {
        super(context);
        dots = new ArrayList<>();
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (eventaction) {
            case MotionEvent.ACTION_UP:
                int dotTouchCount = 0;
                for (Dot d : dots) {
                    if (withinDot(x, y, d)) {
                        d.setTouchCount(d.getTouchCount()+1);
                        d.setColor(255, 255, 102, 0);
                    }
                    if (d.getTouchCount() >= 1) {
                        dotTouchCount+=1;
                    }
                }
                if (dotTouchCount == 3) {
                    nextLevel(1);
                }
                break;

        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < dots.size(); i++) {
            Dot d = dots.get(i);
            canvas.drawCircle(d.getxPosition(), d.getyPosition(), d.getRadius(), d.getColor());
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dots.add(new Dot(Color.argb(255, 255, 102, 0), w/2, h/4, w/10, false));
        dots.add(new Dot(Color.argb(255, 255, 102, 0), w/2, (h/4)*2, w/10, false));
        dots.add(new Dot(Color.argb(255, 255, 102, 0), w/2, (h/4)*3, w/10, false));
        dots.add(new Dot(Color.BLUE, w/5, h/4, w/10, false));
        dots.add(new Dot(Color.BLUE, w/5, (h/4)*2, w/10, false));
        dots.add(new Dot(Color.BLUE, w/5, (h/4)*3, w/10, false));
    }

    @Override
    public void pregame() {
    }

}
