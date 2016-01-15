package com.example.trh.dotgame.Tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import com.example.trh.dotgame.GameView;
import com.example.trh.dotgame.R;

/**
 * Created by trh on 1/9/16.
 */
public class DrawingTool implements Tool {

    private Bitmap image;
    private GameView gameView;
    private int dotSize;
    private int color;

    public DrawingTool(GameView gView) {
        gameView = gView;
        dotSize = 10;
        color = Color.YELLOW;
        image = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.drawingtool);
    }

    @Override
    public void actionUp(int x, int y) {

    }

    @Override
    public Bitmap getImage() {
        return image;
    }

    public int getDotSize() {
        return dotSize;
    }

    public int getColor() {
        return color;
    }
}
