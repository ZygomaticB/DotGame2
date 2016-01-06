package com.example.trh.dotgame;

import android.graphics.Bitmap;
import android.view.MotionEvent;

/**
 * Created by trh on 1/5/16.
 */
public class EraserTool implements Tool {
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public Bitmap getImage() {
        return null;
    }
}
