package com.g4.progark.battleships.models;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.g4.progark.battleships.utility.Constants;
import com.g4.progark.battleships.utility.Coordinate;

/**
 * Created by ahmed on 04.04.2016.
 */
public class GameTile {



    private Drawable gameTileState;

    private Coordinate top_left;

    private TileState tileState;






    public GameTile(Drawable gameTileState, Coordinate top_left) {
        this.gameTileState = gameTileState;
        this.top_left = top_left;

    }

    public void drawBorders(Canvas canvas, float x, float y, float width, float height){

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(Constants.TILE_BORDER_WIDTH);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(x,y,x+width,y+height, paint);

    }

    public void drawTile(Canvas canvas, float x, float y, float width, float height){

        drawBorders(canvas, x,y,width,height);

        gameTileState.draw(canvas,x,y,width,height);


    }

    public void setGameTile(Drawable gameTileState) {

        this.gameTileState = gameTileState;

        if(gameTileState instanceof EmptyTile){
            tileState = TileState.EMPTY_TILE;
        }


    }

    public Drawable getGameTileState() {
        return gameTileState;
    }

    public Coordinate getTop_left() {
        return top_left;
    }
}
