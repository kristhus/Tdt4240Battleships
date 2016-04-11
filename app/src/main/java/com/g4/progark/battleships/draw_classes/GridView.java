package com.g4.progark.battleships.draw_classes;

import android.graphics.Canvas;

import com.g4.progark.battleships.models.Drawable;
import com.g4.progark.battleships.models.EmptyTile;
import com.g4.progark.battleships.models.GameTile;
import com.g4.progark.battleships.models.TileState;
import com.g4.progark.battleships.utility.Constants;
import com.g4.progark.battleships.utility.Coordinate;

import java.util.ArrayList;
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



    private HashMap<Coordinate, GameTile> tiles;
    //private HashMap<Coordinate, String> tiles;

    //private ArrayList<GameTile> tiles;

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
        //tiles = new HashMap<Coordinate, GameTile>();

        init();

    }



    public void init(){

        float ycoordinate = Constants.TILE_BORDER_WIDTH;
        float xcoordinate = Constants.TILE_BORDER_WIDTH;

        for (int i = 0; i < num_cols; i++) {
            //xcoordinate = xcoordinate+i*tile_width;
            for (int j = 0; j < num_rows; j++) {

                //Coordinate tile_coordinate = new Coordinate(xcoordinate+i*tile_width, ycoordinate+j*tile_height);


                //ycoordinate = ycoordinate+j*tile_height;

                //tiles.add(new GameTile(TileState.EMPTY_TILE,(float)i,(float)j ));
                tiles.put(new Coordinate((float)i,(float)j), new GameTile(TileState.EMPTY_TILE, xcoordinate+i*tile_width, ycoordinate+j*tile_height));
            }
        }

    }


    //Second overloaded constructor
    public GridView(HashMap<Coordinate,GameTile> intiles, int num_cols, int num_rows) throws Exception {
        this.num_cols = num_cols;
        this.num_rows = num_rows;


        tile_width = Constants.SCREEN_WIDTH / (float) num_cols;
        tile_height = Constants.SCREEN_HEIGHT / (float) num_rows;


        tile_rect_width = tile_width - 2 * Constants.TILE_BORDER_WIDTH;
        tile_rect_height = tile_height - 2 * Constants.TILE_BORDER_WIDTH;

        if (tile_rect_width <= 0 || tile_rect_height <= 0 || tile_height <= tile_rect_height || tile_width <= tile_rect_width) {
            throw new Exception("Dimensions of tile wrong");
        }

        this.tiles = intiles;
    }


    public void draw(Canvas canvas) {

        /*
        for(Coordinate cor: tiles.keySet()){
            tiles.get(cor).drawTile(canvas, cor.getX(), cor.getY());
        }
        */

       for(GameTile tile: tiles.values()){
           tile.drawTile(canvas, tile.getC(), tile.getR(), tile_rect_width, tile_rect_height);
       }


        /*
        for (GameTile tile : tiles) {
            tile.drawTile(canvas,tile_rect_width, tile_rect_height);
        }
        */
    }


    public GameTile getTile(float x, float y){

        int column = (int)(x/tile_width);
        int row = (int)(y/tile_height);

        Coordinate c = new Coordinate(column,row);


        GameTile tile = tiles.get(c);

       // Set<Coordinate> cs = tiles.keySet();


        return tile;
        //return tiles.get(new Coordinate(x/tile_width, y/tile_height));

    }


    public HashMap<Coordinate, GameTile> getTiles() {
        return tiles;
    }

    public void setTiles(HashMap<Coordinate, GameTile> tiles) {
        this.tiles = tiles;
    }
}
