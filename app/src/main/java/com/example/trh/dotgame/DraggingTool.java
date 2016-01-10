package com.example.trh.dotgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by trh on 12/19/15.
 */
public class DraggingTool implements Tool {

    private GameView gameView;
    private Bitmap image;
    private int movingDotdx = -1;
    private int movingX;
    private int movingY;

    public DraggingTool(GameView gameView) {
        this.gameView = gameView;
        image = BitmapFactory.decodeResource(gameView.getResources(), R.drawable.drag_tool);
    }

    @Override
    public void actionUp(int x, int y) {
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch(eventaction) {
            case MotionEvent.ACTION_MOVE:
                Dot dot = gameView.dotAtXY(x, y);
                if (dot != null) {
                    dot.setxPosition(x);
                    dot.setyPosition(y);
                } else {
                    return false;
                }
                break;
        }
        return true;
    }*/

    @Override
    public Bitmap getImage() {
        return image;
    }
}
