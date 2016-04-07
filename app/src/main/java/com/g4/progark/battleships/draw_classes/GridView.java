package com.g4.progark.battleships.draw_classes;

import android.graphics.Canvas;

import com.g4.progark.battleships.models.Drawable;
import com.g4.progark.battleships.models.EmptyTile;
import com.g4.progark.battleships.models.GameTile;
import com.g4.progark.battleships.utility.Constants;
import com.g4.progark.battleships.utility.Coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ahmed on 04.04.2016.
 */
public class GridView{


    private final int num_cols;
    private final int num_rows;

    //dimensions of the tile including borders
    private final float tile_width;
    private final float tile_height;

    //the dimensions of the rectangle inside the tile when excluding the borders

    private final float tile_rect_width;
    private final float tile_rect_height;



    private Map<Coordinate, GameTile> tiles;

    public GridView(int num_cols, int num_rows) throws Exception {
        this.num_cols = num_cols;
        this.num_rows = num_rows;



        tile_width = Constants.SCREEN_WIDTH/(float)num_cols;
        tile_height = Constants.SCREEN_HEIGHT/(float)num_rows;


        tile_rect_width = tile_width-2*Constants.TILE_BORDER_WIDTH;
        tile_rect_height = tile_height-2*Constants.TILE_BORDER_WIDTH;

        if(tile_rect_width <= 0 || tile_rect_height <= 0 || tile_height <= tile_rect_height || tile_width <= tile_rect_width){
            throw new Exception("Dimensions of tile wrong");
        }


        tiles = new HashMap<Coordinate, GameTile>();

        init();

    }

    public void init(){

        float ycoordinate = Constants.TILE_BORDER_WIDTH;
        float xcoordinate = Constants.TILE_BORDER_WIDTH;

        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {

                Coordinate tile_coordinate = new Coordinate(xcoordinate+j*tile_width, ycoordinate+i*tile_height);

                tiles.put(new Coordinate((float)i,(float)j), new GameTile(new EmptyTile(), tile_coordinate));
            }
        }

    }


    public void draw(Canvas canvas) {

       for(GameTile tile: tiles.values()){
           tile.drawTile(canvas, tile.getTop_left().getX(), tile.getTop_left().getY(), tile_rect_width, tile_rect_height);
       }

    }


    public GameTile getTile(float x, float y){

        int column = (int)(x/tile_width);
        int row = (int)(y/tile_height);

        Coordinate c = new Coordinate((float)row,(float)column);


        GameTile tile = tiles.get(c);

        Set<Coordinate> cs = tiles.keySet();


        return tile;
        //return tiles.get(new Coordinate(x/tile_width, y/tile_height));

    }
}
