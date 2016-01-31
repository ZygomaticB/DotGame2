package com.example.trh.dotgame.Levels;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.MotionEvent;

import com.example.trh.dotgame.Dot;
import com.example.trh.dotgame.R;

import java.util.ArrayList;

public class Level2 extends Level {

    public Level2(Context context) {
        super(context);
        dots = new ArrayList<>();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dots.add(new Dot(Color.argb(255, 255, 102, 0), w / 2, h / 2, w / 10, false));
        dots.add(new Dot(Color.BLUE, w/5, h/2, w/10, false));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Dot d : dots) {
            canvas.drawCircle(d.getxPosition(), d.getyPosition(), d.getRadius(), d.getColor());
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int actionevent = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();

        switch(actionevent) {
            case MotionEvent.ACTION_UP:
                if (withinDot(X, Y, dots.get(0))) {
                    nextLevel(3);
                }
                break;
        }
        return true;
    }

    @Override
    public void pregame() {
        playSound(myContext, R.raw.touch_again);
    }

    public static void playSound(Context context, int soundID) {
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }
}
