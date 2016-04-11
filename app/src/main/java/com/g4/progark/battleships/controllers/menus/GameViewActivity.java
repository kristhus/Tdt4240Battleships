package com.g4.progark.battleships.controllers.menus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.g4.progark.battleships.R;
import com.g4.progark.battleships.draw_classes.GameView;
import com.g4.progark.battleships.draw_classes.GridView;
import com.g4.progark.battleships.models.GameMap;
import com.g4.progark.battleships.models.GameTile;
import com.g4.progark.battleships.models.Player;
import com.g4.progark.battleships.utility.Constants;
import com.g4.progark.battleships.utility.Coordinate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GameViewActivity extends AppCompatActivity {


    private int player;

    private GridView grid1;
    private GridView grid2;

    private GameView gameView;



    //SharedPreferences shared = getSharedPreferences("test", Context.MODE_PRIVATE);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
        this.player1 = new Player();
        this.player2 = new Player();

        this.player1.setName("Cola");
        this.player2.setName("Pepsi");

        */




        try {

            if(Constants.CURRENT_PLAYER == 1){
                if(Constants.GRID1_TILES == null){
                    grid1 = new GridView(Constants.NUMBER_COLUMN_TILES, Constants.NUMBER_ROW_TILES);
                } else {
                    grid1 = new GridView(Constants.GRID1_TILES, Constants.NUMBER_COLUMN_TILES, Constants.NUMBER_ROW_TILES);
                }

                gameView = new GameView(this, "sea", grid1);
            } else {
                if(Constants.GRID2_TILES == null){
                    grid2 = new GridView(Constants.NUMBER_COLUMN_TILES, Constants.NUMBER_ROW_TILES);
                } else {
                    grid2 = new GridView(Constants.GRID2_TILES, Constants.NUMBER_COLUMN_TILES, Constants.NUMBER_ROW_TILES);
                }

                gameView = new GameView(this, "sea", grid2);
            }

        } catch(Exception e){
            e.printStackTrace();
        }



        //loadState();





        /*
        gameView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

               gameView.drawNewState(motionEvent.getX(), motionEvent.getY());

                //saveState();

                Constants.GRID1_TILES = gameView.getCurrentGridView().getTiles();

                Intent intent = new Intent(getApplicationContext(), IntermediateActivity.class);

                startActivity(intent);

                return true;
            }
        });
        */


        setContentView(gameView);
        Toast.makeText(this, "Player " + Constants.CURRENT_PLAYER + " may start", Toast.LENGTH_SHORT).show();

        //map name should be passed in as a parameter, it is at the moment hard coded


    }

    /*
    public void loadState(){



        SharedPreferences shared = getSharedPreferences("test", Context.MODE_PRIVATE);

        if(shared.contains("counter")) {
            counter = shared.getInt("counter", -1);

            Toast.makeText(this, "The new counter is " + counter, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Counter has not been saved yet", Toast.LENGTH_LONG).show();
        }
        */
                /*

                Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();

                String json = shared.getString("grid1", "");
                HashMap<Coordinate, GameTile> tiles = (HashMap<Coordinate,GameTile>)gson.fromJson(json, HashMap.class);

                grid1.setTiles(tiles);
                gameView.setCurrentGridView(grid1);


    }
    */
    /*

    public void saveState(){

        SharedPreferences shared = getSharedPreferences("test", Context.MODE_PRIVATE);

        SharedPreferences.Editor data = shared.edit();
        counter++;
        data.putInt("counter", counter);

        data.commit();

        Toast.makeText(this, "Counter was saved", Toast.LENGTH_LONG).show();

        /*
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();

        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor data = shared.edit();

        HashMap<Coordinate, GameTile> tiles = grid1.getTiles();

        String json = gson.toJson(tiles);

        Log.e("json", json);



        data.putString("grid1",json);
        data.commit();



    }
    */

    /*
    @Override
    protected void onResume() {
        super.onResume();

        if(player == 1){
            gameView.setCurrentGridView(grid1);
            player = 2;
        } else {
            gameView.setCurrentGridView(grid2);
            player = 1;
        }
        setContentView(gameView);
    }
    */


    /*

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt("player", player);
        outState.putSerializable("tiles_player1", grid1.getTiles());
        outState.putSerializable("tiles_player2", grid2.getTiles());



        //outState.putSerializable("tiles", h);
        //outState.putSerializable("game_view", gameView);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        grid1.setTiles((HashMap<Coordinate,GameTile>) savedInstanceState.get("tiles_player1"));
        grid2.setTiles((HashMap<Coordinate,GameTile>) savedInstanceState.get("tiles_player2"));

        player = (int)savedInstanceState.get("player");
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
