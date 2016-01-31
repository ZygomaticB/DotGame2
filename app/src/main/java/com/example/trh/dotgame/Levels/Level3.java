package com.example.trh.dotgame.Levels;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.MotionEvent;

import com.example.trh.dotgame.Dot;
import com.example.trh.dotgame.R;

import java.util.ArrayList;

public class Level3 extends Level {

    private int movingDot = -1;

    public Level3(Context context) {
        super(context);
        dots = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Dot d : dots) {
            canvas.drawCircle(d.getxPosition(), d.getyPosition(), d.getRadius(), d.getColor());
        }
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dots.add(new Dot(Color.argb(255, 255, 102, 0), w / 2, h / 2, w / 10, false));
        dots.add(new Dot(Color.BLUE, w / 5, h / 2, w / 10, true));
        dots.add(new Dot(Color.GREEN, w / 5 * 4, h / 2, w / 10, true));
    }

    public boolean onTouchEvent(MotionEvent event) {
        int actionevent = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();

        switch(actionevent) {
            case MotionEvent.ACTION_UP:
                if ((movingDot > -1) && withinDot(dots.get(movingDot).getxPosition(),
                        dots.get(movingDot).getyPosition(), dots.get(0))) {
                    mergeWithCenter(dots.get(movingDot).getColor().getColor());
                    dots.remove(movingDot);
                }
                if (dots.size() == 1) {
                    // do animation to move the dots out
                    nextLevel(4);
                }
                movingDot = -1;
                break;
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i < dots.size(); i++) {
                    if (withinDot(X, Y, dots.get(i)) && dots.get(i).isDragable()) {
                        movingDot = i;
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (movingDot > -1) {
                    dots.get(movingDot).setxPosition(X);
                    dots.get(movingDot).setyPosition(Y);
                }
        }
        return true;
    }

    private void mergeWithCenter(int colorChange) {
        int newColor = mixColors(dots.get(0).getColor().getColor(), colorChange);
        dots.get(0).setColor(255, Color.red(newColor), Color.green(newColor), Color.blue(newColor));
    }

    private int mixColors(int color1, int color2) {
        int r1, g1, b1, r2, g2, b2;
        r1 = Color.red(color1);
        g1 = Color.green(color1);
        b1 = Color.blue(color1);
        r2 = Color.red(color2);
        g2 = Color.green(color2);
        b2 = Color.blue(color2);

        int r3 = (r1 + r2)/2;
        int g3 = (g1 + g2)/2;
        int b3 = (b1 + b2)/2;
        return Color.argb(255, r3, g3, b3);
    }

    @Override
    public void pregame() {
        playSound(myContext, R.raw.stack);
    }

    public static void playSound(Context context, int soundID) {
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }
}
