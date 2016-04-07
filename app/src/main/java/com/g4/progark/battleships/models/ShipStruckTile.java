package com.g4.progark.battleships.models;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ahmed on 07.04.2016.
 */
public class ShipStruckTile implements Drawable{


    @Override
    public void draw(Canvas canvas, float x, float y, float width, float height) {

        float smallerDimension = width <= height ? width : height;

        Paint p = new Paint();
        p.setColor(Color.RED);

        canvas.drawCircle(x + width/2,y+height/2,smallerDimension/2,p);
    }
}
