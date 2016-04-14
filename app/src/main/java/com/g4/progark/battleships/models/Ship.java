package com.g4.progark.battleships.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.g4.progark.battleships.utility.Constants;

/**
 * Created by Kristian on 11/03/2016.
 */
public class Ship {

    private Bitmap shipImage;

    //Number of tiles the ship will spann horizontally
    private int num_tile_rows;

    //Number of tile the ship will span horizontally
    private int num_tile_cols;

    String name;


    public Ship(Context context, String ship_img_name, int num_tile_rows, int num_tile_cols, String name) {
        this.num_tile_rows = num_tile_rows;
        this.num_tile_cols = num_tile_cols;
        this.name = name;



        //will be improved later if time allows. Here a ship image is being loaded and scaled down which is inefficient memory consumption wise
        //better to scale the bitmap as it is loaded using BitmapFactory options or other methods ....
        Bitmap temp = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(ship_img_name, "drawable", context.getPackageName()));
        //shipImage = Bitmap.createScaledBitmap(temp, (int) Constants.SHIP_GRID_WIDTH, (int)Constants.SHIP_GRID_HEIGHT,true);

    }
}
