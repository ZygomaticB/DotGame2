package com.example.trh.dotgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.view.View;

import java.util.List;

/**
 * Created by trh on 1/12/16.
 */
public class PathExView extends View {

    private List<Dot> dots;

    public  PathExView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dots.add(new Dot(Color.BLUE, w/2, h/2, w/10, false));
        dots.add(new Dot(Color.YELLOW, w/2, h/2, w/10, false));
    }
}
