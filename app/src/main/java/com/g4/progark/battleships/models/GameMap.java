package com.g4.progark.battleships.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.g4.progark.battleships.utility.Constants;

/**
 * Created by Kristian on 11/03/2016.
 */
public class GameMap {

    private Bitmap area;

    // Audio classes should be discussed before further work (using own interfaces should be done)


    public GameMap(Context context, String map_name){

        Bitmap temp = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(map_name, "drawable", context.getPackageName()));


        area = Bitmap.createScaledBitmap(temp, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT,true);
    }


    public Bitmap getArea() {

        return area;
    }

}
