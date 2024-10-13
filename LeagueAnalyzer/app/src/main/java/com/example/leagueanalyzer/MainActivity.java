package com.example.leagueanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * MainActivity class serves as the controller for the Main0 (home) screen
 * @author Earl Lontok
 */
public class MainActivity extends AppCompatActivity {

    public static ArrayList<Game> games = new ArrayList<>();

    /**
     * Sets the layout to activity_main.xml (displays the home screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Launches the ChampionsActivity class when the Champions image is clicked
     * @param view the view of interest
     */
    public void showActivityChampions(View view){
        Intent intent = new Intent(this, ChampionsActivity.class);
        startActivity(intent);
    }

    /**
     * Launches the GameModesActivity class when the Game Modes image is clicked
     * @param view the view of interest
     */
    public void showActivityGameModes(View view){
        Intent intent = new Intent(this, GameModesActivity.class);
        startActivity(intent);
    }

    /**
     * Launches the ManageGamesActivity class when the Manage Games image is clicked
     * @param view the view of interest
     */
    public void showActivityManageGames(View view){
        Intent intent = new Intent(this, ManageGamesActivity.class);
        startActivity(intent);
    }

    /**
     * Launches the StatisticsActivity class when the Statistics image is clicked
     * @param view the view of interest
     */
    public void showActivityStatistics(View view){
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

}