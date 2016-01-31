package com.example.trh.dotgame.Levels;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import com.example.trh.dotgame.Dot;
import com.example.trh.dotgame.R;

import java.util.ArrayList;

public class Level1 extends Level{

    public Level1(Context context) {
        super(context);
        dots = new ArrayList<>();
    }

    public static void playSound(Context context, int soundID) {
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }

    public void pregame() {
        playSound(myContext, R.raw.touchorange);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int actionevent = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();

        switch(actionevent) {
            case MotionEvent.ACTION_UP:
                if (withinDot(X, Y, dots.get(0))) {
                    nextLevel(2);
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(dots.get(0).getxPosition(), dots.get(0).getyPosition(),
                dots.get(0).getRadius(), dots.get(0).getColor());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dots.add(new Dot(Color.argb(255, 255, 102, 0), w/2, h/2, w/10, false));
    }
}
