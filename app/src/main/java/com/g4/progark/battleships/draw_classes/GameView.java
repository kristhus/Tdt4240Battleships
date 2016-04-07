package com.g4.progark.battleships.draw_classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.g4.progark.battleships.controllers.AndroidMenu;
import com.g4.progark.battleships.models.EmptyStruckTile;
import com.g4.progark.battleships.models.EmptyTile;
import com.g4.progark.battleships.models.GameMap;
import com.g4.progark.battleships.models.GameTile;

/**
 * Created by ahmed on 31.03.2016.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback{


    private GameMap map;
    private SurfaceHolder holder;
    private GridView gridView;

    private Thread gameThread;


    public GameView(Context context, String map_name) throws Exception {
        super(context);
        this.holder = getHolder();
        this.holder.addCallback(this);

        this.map = new GameMap(context, map_name);
        this.gridView = new GridView(10,20);
    }





    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //drawGameView();

        GameTile tile = gridView.getTile(event.getX(), event.getY());

        tile.setGameTile(new EmptyStruckTile());

        drawGameView();

        return true;
    }

    public void drawGameView(){



        Canvas canvas = holder.lockCanvas();
        //canvas.draw

        if(canvas != null){

            canvas.drawColor(Color.WHITE);
            //canvas.drawCircle(50, 50, 10, null);


            canvas.drawBitmap(map.getArea(), 0, 0, null);
            gridView.draw(canvas);


            holder.unlockCanvasAndPost(canvas);
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        gameThread = new Thread(){
            @Override
            public void run() {
                 drawGameView();
            }
        };

        gameThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        if(gameThread != null) {
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
