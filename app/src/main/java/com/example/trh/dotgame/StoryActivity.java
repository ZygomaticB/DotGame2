package com.example.trh.dotgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.trh.dotgame.Levels.Level;
import com.example.trh.dotgame.Levels.Level1;
import com.example.trh.dotgame.Levels.Level2;
import com.example.trh.dotgame.Levels.Level3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trh on 12/19/15.
 */
public class StoryActivity extends Activity {

    private List<Level> levels;
    private Level curLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        levels = new ArrayList<>();
        Level level = new Level1(this);
        Level level2 = new Level2(this);
        Level level3 = new Level3(this);
        levels.add(0, level);
        levels.add(1, level2);
        levels.add(2, level3);
        curLevel = level;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("Value1");
            curLevel = levels.get(value-1);
            setContentView((View) curLevel);
        } else {
            setContentView((View)curLevel);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        curLevel.pregame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }
}
