package com.example.trh.dotgame.Levels;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.trh.dotgame.Dot;
import com.example.trh.dotgame.StoryActivity;

import java.util.List;

public abstract class Level extends View {

    protected List<Dot> dots;
    protected Context myContext;

    public Level(Context context) {
        super(context);
        myContext = context;
    }

    public abstract void pregame();

    public void nextLevel(int level) {
        try {
            wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(myContext, StoryActivity.class);
        intent.putExtra("Value1", level);
        myContext.startActivity(intent);
    }

    protected boolean withinDot(int x, int y, Dot dot) {
        int dotX = dot.getxPosition();
        int dotY = dot.getyPosition();
        int radius = dot.getRadius();
        int xMin = dotX - radius;
        int xMax = dotX + radius;
        int yMin = dotY - radius;
        int yMax = dotY + radius;
        return ((xMin < x) && (xMax > x) && (yMin < y) && (yMax > y));
    }
}
