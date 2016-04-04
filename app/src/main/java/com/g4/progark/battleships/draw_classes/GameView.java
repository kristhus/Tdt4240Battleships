package com.g4.progark.battleships.draw_classes;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.g4.progark.battleships.controllers.AndroidMenu;
import com.g4.progark.battleships.models.GameMap;

/**
 * Created by ahmed on 31.03.2016.
 */
public class GameView extends MatchSurfaceView {


    GameMap map;

    public GameView(AndroidMenu context) {
        super(context);

        map = new GameMap(this.getContext(), "map");
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Canvas canvas = super.holder.lockCanvas();

        if(canvas != null){

            GameMap map = new GameMap(this.mainActivity, "map");

            canvas.drawBitmap(map.getArea(),0,0,null);

            super.holder.unlockCanvasAndPost(canvas);
        }

        return true;
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
