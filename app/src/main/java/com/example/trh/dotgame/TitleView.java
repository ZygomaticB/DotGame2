package com.example.trh.dotgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by trh on 1/10/16.
 */
public class TitleView extends View {

    private Context myContext;
    private int screenH;
    private int screenW;
    private Paint textPaint;

    public TitleView(Context context) {
        super(context);
        myContext = context;
        textPaint = new Paint();
        textPaint.setTextSize(22);
        textPaint.setColor(Color.BLACK);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int actionevent = event.getAction();
        int X = (int) event.getX();
        int Y = (int) event.getY();

        switch (actionevent) {
            case MotionEvent.ACTION_UP:
                if (Y < screenH/2) {
                    Intent storyIntent = new Intent(myContext, StoryActivity.class);
                    myContext.startActivity(storyIntent);
                } else if (Y > screenH / 2) {
                    Intent freeMode = new Intent(myContext, FreePlayActivity.class);
                    myContext.startActivity(freeMode);
                }
                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Story Mode", screenW/2, screenH/4, textPaint);
        canvas.drawText("Free Mode", screenW/2, (screenH/4)*3, textPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }
}
