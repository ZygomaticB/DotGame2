package com.example.trh.dotgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;

/**
 * Created by trh on 1/5/16.
 */
public class EraserTool implements Tool {

    private Bitmap image;
    private GameView myView;
    private int size;

    public EraserTool(GameView gameView) {
        myView = gameView;
        image = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.eraser_tool);
        size = 100;
    }

    @Override
    public void actionUp(int x, int y) {
        myView.removeDots(x, y, size);
    }

    @Override
    public Bitmap getImage() {
        return image;
    }
}
