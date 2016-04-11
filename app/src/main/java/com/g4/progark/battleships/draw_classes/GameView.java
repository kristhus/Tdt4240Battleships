package com.g4.progark.battleships.draw_classes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import com.g4.progark.battleships.controllers.AndroidMenu;
import com.g4.progark.battleships.controllers.menus.IntermediateActivity;
import com.g4.progark.battleships.controllers.menus.Lobby;
import com.g4.progark.battleships.controllers.menus.MainActivity;
import com.g4.progark.battleships.models.EmptyStruckTile;
import com.g4.progark.battleships.models.EmptyTile;
import com.g4.progark.battleships.models.GameMap;
import com.g4.progark.battleships.models.GameTile;
import com.g4.progark.battleships.models.TileState;
import com.g4.progark.battleships.utility.Constants;

import java.io.Serializable;

/**
 * Created by ahmed on 31.03.2016.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback{


    private GameMap map;
    private SurfaceHolder holder;

    //the gridview for both players
    /*
    private GridView gridView1;
    private GridView gridView2;
    */

    //reference to the gridview of the user playing the current turn

    private GridView currentGridView;

    private Thread gameThread;

    public GameView(Context context,String map_name, GridView currentGridView) {
        super(context);
        this.holder = getHolder();
        this.holder.addCallback(this);
        this.currentGridView = currentGridView;
        this.map = new GameMap(context, map_name);

    }




/*
    public GameView(Context context, String map_name, int num_cols, int num_rows) {
        super(context);
        this.holder = getHolder();
        this.holder.addCallback(this);

        this.map = new GameMap(context, map_name);
        try {
            this.gridView1 = new GridView(num_cols,num_rows);
            this.gridView2 = new GridView(num_cols,num_rows);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //setting the current gridview to that of player 1
        this.currentGridView = gridView1;
        //Constants.CURRENT_PLAYER = 1;
    }

    public boolean isCurrentGridSet(){
        return currentGridView != null;
    }

    */
    public void switchTurns(){

        if(Constants.CURRENT_PLAYER == 1){

            Constants.GRID1_TILES = currentGridView.getTiles();
            Constants.CURRENT_PLAYER = 2;


        } else {

            Constants.GRID2_TILES = currentGridView.getTiles();
            Constants.CURRENT_PLAYER = 1;
        }

    }



    public void drawNewState(float x, float y){
        GameTile tile = currentGridView.getTile(x, y);

        tile.setTileState(TileState.EMPTY_STRUCK_TILE);

        drawGameView();

    }

    public void setCurrentGridView(GridView currentGridView) {
        this.currentGridView = currentGridView;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //drawGameView();

        if(event.getAction() == MotionEvent.ACTION_DOWN) {

            GameTile tile = currentGridView.getTile(event.getX(), event.getY());

            tile.setTileState(TileState.EMPTY_STRUCK_TILE);

            drawGameView();

            switchTurns();


            Intent intent = new Intent(getContext(), IntermediateActivity.class);

            getContext().startActivity(intent);

            return true;
        } else {
            return false;
        }
    }



    public GridView getCurrentGridView() {
        return currentGridView;
    }

    public void drawGameView(){



        Canvas canvas = holder.lockCanvas();
        //canvas.draw



        if(canvas != null){

            canvas.drawColor(Color.WHITE);
            //canvas.drawCircle(50, 50, 10, null);


            canvas.drawBitmap(map.getArea(), 0, 0, null);
            currentGridView.draw(canvas);


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
