package com.example.trh.dotgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;

/**
 * Created by trh on 12/19/15.
 */
public class DotPlacingTool implements Tool {

    private GameView gView;
    private Bitmap image;

    public DotPlacingTool(GameView gView) {
        this.gView = gView;
        image = BitmapFactory.decodeResource(gView.getResources(), R.drawable.dot_placer);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch(eventaction) {

            case MotionEvent.ACTION_UP:
                if (y > 100) {
                    gView.placeDot(x, y);
                }
        }
        return true;
    }

    public Bitmap getImage() {
        return image;
    }
}
