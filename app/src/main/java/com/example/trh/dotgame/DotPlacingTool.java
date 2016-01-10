package com.example.trh.dotgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Created by trh on 12/19/15.
 */
public class DotPlacingTool implements Tool {

    private GameView gView;
    private Bitmap image;
    private int dotSize = 50;

    public DotPlacingTool(GameView gView) {
        this.gView = gView;
        image = BitmapFactory.decodeResource(gView.getResources(), R.drawable.dot_placer);
    }

    public void actionUp(int x, int y) {
        gView.placeDot(x, y, dotSize, Color.GREEN);
    }

    public void setDotSize(int size) {
        dotSize = size;
    }

    public int getDotSize() {
        return dotSize;
    }

    public Bitmap getImage() {
        return image;
    }
}
