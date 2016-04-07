package com.g4.progark.battleships.controllers;

import com.g4.progark.battleships.draw_classes.GameView;
import com.g4.progark.battleships.draw_classes.MatchView;
import com.g4.progark.battleships.models.GameEntities;
import com.g4.progark.battleships.models.Player;
import com.g4.progark.battleships.utility.Constants;

/**
 * Created by Kristian on 17/03/2016.
 */
public class GameController {


    private GameView gameView;
    private AndroidMenu menu;
    private GameEntities entities;

    public GameController(AndroidMenu menu, GameEntities entities, String map_name) {
        this.menu = menu;
        this.entities = entities;
        Constants.CURRENT_MAP_NAME = map_name;

        //gameView = new GameView(this);

    }


    public void update() {
       // gameView.update();
    }

    /** Fire at positions on the grid
     *
     * @param x Row value
     * @param y Column value

    public void fire(int x, int y) {
        if(entities.getMap().getGrid()[x][y] != 1) {
            entities.getMap().getGrid()[x][y] = 1;
            update();
        }
    }
*/


}
