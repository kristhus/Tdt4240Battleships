package com.g4.progark.battleships.utility;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.g4.progark.battleships.draw_classes.GameView;
import com.g4.progark.battleships.models.GameTile;

import java.util.HashMap;

/**
 * Created by ahmed on 03.04.2016.
 */
public class Constants {

    //public static final int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final float SCREEN_WIDTH = 500;


    //public static final int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;
    public static final float SCREEN_HEIGHT = 800;




    public static String CURRENT_MAP_NAME;
    public static final int TILE_BORDER_WIDTH = 1;

    public static int CURRENT_PLAYER = 1;

    public static Canvas CURRENT_CANVAS = null;



    public static int NUMBER_ROW_TILES = 25;
    public static int NUMBER_COLUMN_TILES = 10;

    public static HashMap<Coordinate, GameTile> GRID1_TILES = null;
    public static HashMap<Coordinate, GameTile> GRID2_TILES = null;



}
