package com.example.trh.dotgame;

import android.graphics.Bitmap;
import android.view.MotionEvent;

/**
 * Created by trh on 12/19/15.
 */
public interface Tool {

    boolean onTouchEvent(MotionEvent event);
    Bitmap getImage();
}
