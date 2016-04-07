package com.g4.progark.battleships.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.g4.progark.battleships.R;
import com.g4.progark.battleships.utility.Constants;

/**
 * Created by Kristian on 11/03/2016.
 */
public class GameMap {

    private final Bitmap area;


    // Audio classes should be discussed before further work (using own interfaces should be done)

    public GameMap(Context context, String map_name){

        //Bitmap temp = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(map_name, "drawable", context.getPackageName()));
        Bitmap temp = BitmapFactory.decodeResource(context.getResources(), R.drawable.sea);


        area = Bitmap.createScaledBitmap(temp, (int)Constants.SCREEN_WIDTH, (int)Constants.SCREEN_HEIGHT,true);
        //area = Bitmap.createScaledBitmap(temp, 40  , 40,true);
    }




    public Bitmap getArea() {
        return area;
    }




}
