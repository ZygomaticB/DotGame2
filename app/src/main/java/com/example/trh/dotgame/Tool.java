package com.example.trh.dotgame;

import android.graphics.Bitmap;
import android.view.MotionEvent;

/**
 * Created by trh on 12/19/15.
 */
public interface Tool {

    void actionUp(int x, int y);
    //boolean onTouchEvent(MotionEvent event);
    Bitmap getImage();
}
