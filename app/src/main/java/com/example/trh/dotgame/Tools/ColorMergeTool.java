package com.example.trh.dotgame.Tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.trh.dotgame.GameView;

/**
 * Created by trh on 1/12/16.
 */
public class ColorMergeTool implements Tool {

    private GameView gameView;

    public ColorMergeTool(GameView gView){
        gameView = gView;
    }

    @Override
    public void actionUp(int x, int y) {

    }

    @Override
    public Bitmap getImage() {
        return null;
    }
}
