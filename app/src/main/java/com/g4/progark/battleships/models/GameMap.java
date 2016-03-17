package com.g4.progark.battleships.models;

import android.graphics.Bitmap;

/**
 * Created by Kristian on 11/03/2016.
 */
public class GameMap {

    private Bitmap area;
    private int[][] grid;
    private int width;
    private int length;

    // Audio classes should be discussed before further work (using own interfaces should be done)
    public GameMap(Bitmap area, int width, int length) {
        grid = new int[width][length];
        this.width = width;
        this.length = length;
    }


    public Bitmap getArea() {
        return area;
    }

    public void setArea(Bitmap area) {
        this.area = area;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}
