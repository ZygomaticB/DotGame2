package com.example.trh.dotgame.Levels;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.trh.dotgame.Dot;
import com.example.trh.dotgame.StoryActivity;
import com.example.trh.dotgame.R;

/**
 * Created by trh on 1/10/16.
 */
public class Level1 extends View implements Level{

    private Context myContext;
    private Dot orangeDot;
    private int screenH;
    private int screenW;
    private SoundPool sounds;
    private static int touchOrange;
    private AudioManager audioManager;
    private float volume;

    public Level1(Context context) {
        super(context);
        myContext = context;


        //playSound(myContext, touchOrange);
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
                if (orangeDot.getxPosition()+orangeDot.getRadius() > X &&
                        orangeDot.getxPosition()-orangeDot.getRadius() < X &&
                        orangeDot.getyPosition()-orangeDot.getRadius() < Y &&
                        orangeDot.getyPosition()+orangeDot.getRadius() > Y) {
                    Log.d("level", "withindot");
                    nextLevel();
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(orangeDot.getxPosition(), orangeDot.getyPosition(),
                orangeDot.getRadius(), orangeDot.getColor());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenH = h;
        screenW = w;
        orangeDot = new Dot(Color.argb(255, 255, 102, 0), w/2, h/2, w/10, false);
    }

    private void nextLevel() {
        Intent intent = new Intent(myContext, StoryActivity.class);
        intent.putExtra("Value1", 2);
        myContext.startActivity(intent);
    }
}
