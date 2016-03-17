package com.g4.progark.battleships.draw_classes;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.g4.progark.battleships.controllers.AndroidMenu;

/**
 * Created by Kristian on 11/03/2016.
 */
public abstract class MatchSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    private AndroidMenu mainActivity;
    private SurfaceHolder holder;

    public MatchSurfaceView(AndroidMenu context) {
        super(context);
        this.mainActivity = context;
        this.holder = getHolder();
    }

}
