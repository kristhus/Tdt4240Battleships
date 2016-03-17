package com.g4.progark.battleships.controllers;

import com.g4.progark.battleships.draw_classes.MatchView;
import com.g4.progark.battleships.models.GameEntities;
import com.g4.progark.battleships.models.Player;

/**
 * Created by Kristian on 17/03/2016.
 */
public class GameController {


    private MatchView matchView;
    private AndroidMenu menu;
    private GameEntities entities;

    public GameController(AndroidMenu menu, GameEntities entities) {
        this.menu = menu;
        this.entities = entities;

        matchView = new MatchView(this);

    }


    public void update() {
        matchView.update();
    }

    /** Fire at positions on the grid
     *
     * @param x Row value
     * @param y Column value
     */
    public void fire(int x, int y) {
        if(entities.getMap().getGrid()[x][y] != 1) {
            entities.getMap().getGrid()[x][y] = 1;
            update();
        }
    }



}
