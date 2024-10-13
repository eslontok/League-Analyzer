package com.example.leagueanalyzer;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * ManageGamesActivity class serves as the controller for the Manage Games screen
 * @author Earl Lontok
 */
public class ManageGamesActivity extends AppCompatActivity {

    private Spinner championSpinner;
    private Spinner roleSpinner;
    private EditText gameDurationInput;
    private EditText farmInput;
    private EditText killsInput;
    private EditText deathsInput;
    private EditText assistsInput;
    private EditText totalTeamKillsInput;
    private Spinner victorySpinner;

    private String[] champions = {"Jax", "Kha'Zix", "Ahri", "Ezreal", "Thresh",
            "Pantheon", "Hecarim", "Kassadin", "Lucian", "Taric",
            "Fiora", "Evelynn", "Annie", "Vayne", "Alistar",
            "Kled", "Amumu", "Leblanc", "Tristana", "Nautilus",
            "Tryndamere", "Wukong", "Ryze", "Zeri", "Nami"};

    private String[] roles = {"ASSASSIN", "FIGHTER", "MAGE", "MARKSMAN", "SUPPORT", "TANK"};

    private String[] winLose = {"true", "false"};

    /**
     * Sets the layout to activity_manage_games.xml (displays the Manage Games screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_games);

        championSpinner = findViewById(R.id.championSpinner);
        roleSpinner = findViewById(R.id.roleSpinner);
        gameDurationInput = findViewById(R.id.gameDurationEditText);
        farmInput = findViewById(R.id.farmEditText);
        killsInput = findViewById(R.id.killsEditText);
        deathsInput = findViewById(R.id.deathsEditText);
        assistsInput = findViewById(R.id.assistsEditText);
        totalTeamKillsInput = findViewById(R.id.totalTeamKillsEditText);
        victorySpinner = findViewById(R.id.victorySpinner);

        sortByName();
        ArrayAdapter<String> adapterChampions = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, champions);
        championSpinner.setAdapter(adapterChampions);

        ArrayAdapter<String> adapterRoles = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        roleSpinner.setAdapter(adapterRoles);

        ArrayAdapter<String> adapterWinLose = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, winLose);
        victorySpinner.setAdapter(adapterWinLose);

    }

    /**
     * An event handler for the Submit button
     * Instantiates a Game object and accounts for all possible error inputs
     * @param view the view of interest
     */
    public void submitGame(View view){

        //First 5 games on the 2nd split of 2023
        /*
        MainActivity.games.add(new Game("Kha'Zix", "ASSASSIN", 30, 226, 20, 2, 3, 38, true));
        MainActivity.games.add(new Game("Kha'Zix", "ASSASSIN", 30, 188, 10, 4, 14, 36, true));
        MainActivity.games.add(new Game("Kha'Zix", "ASSASSIN", 26, 187, 18, 2, 5, 39, true));
        MainActivity.games.add(new Game("Kha'Zix", "ASSASSIN", 22, 161, 8, 3, 4, 27, true));
        MainActivity.games.add(new Game("Kha'Zix", "ASSASSIN", 19, 139, 9, 1, 2, 18, true));
        */

        //Support Test Cases
        /*
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 30, 30, 3, 1, 18, 25, true));
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 22, 22, 1, 2, 10, 16, true));
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 26, 26, 1, 2, 14, 20, false));
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 35, 35, 4, 3, 23, 35, true));
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 18, 18, 0, 0, 10, 14, true));
        */

        //Mixed Test Cases
        /*
        MainActivity.games.add(new Game("Kha'Zix", "ASSASSIN", 22, 161, 8, 3, 4, 27, true));
        MainActivity.games.add(new Game("Kha'Zix", "ASSASSIN", 19, 139, 9, 1, 2, 18, true));
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 30, 30, 3, 1, 18, 25, true));
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 22, 22, 1, 2, 10, 16, true));
        MainActivity.games.add(new Game("Thresh", "SUPPORT", 26, 26, 1, 2, 14, 20, false));
        */

        ///*
        String championName = championSpinner.getSelectedItem().toString();
        String role = roleSpinner.getSelectedItem().toString();
        try{
            int gameDuration = Integer.parseInt(gameDurationInput.getText().toString());
            try{
                int farm = Integer.parseInt(farmInput.getText().toString());
                try{
                    int kills = Integer.parseInt(killsInput.getText().toString());
                    try{
                        int deaths = Integer.parseInt(deathsInput.getText().toString());
                        try{
                            int assists = Integer.parseInt(assistsInput.getText().toString());
                            try{
                                int totalTeamKills = Integer.parseInt(totalTeamKillsInput.getText().toString());
                                boolean victory = Boolean.parseBoolean(victorySpinner.getSelectedItem().toString());
                                Game game = new Game(championName, role, gameDuration, farm, kills, deaths, assists, totalTeamKills, victory);
                                MainActivity.games.add(game);
                                Toast.makeText(this, "Game information recorded.", Toast.LENGTH_SHORT).show();
                            }catch(NumberFormatException e){Toast.makeText(this, "Total Team Kills must be an integer.", Toast.LENGTH_SHORT).show();}
                        }catch(NumberFormatException e){Toast.makeText(this, "Assists must be an integer.", Toast.LENGTH_SHORT).show();}
                    }catch(NumberFormatException e){Toast.makeText(this, "Deaths must be an integer.", Toast.LENGTH_SHORT).show();}
                }catch(NumberFormatException e){Toast.makeText(this, "Kills must be an integer.", Toast.LENGTH_SHORT).show();}
            }catch(NumberFormatException e){Toast.makeText(this, "Farm must be an integer.", Toast.LENGTH_SHORT).show();}
        }catch(NumberFormatException e){Toast.makeText(this, "Game Duration must be an integer.", Toast.LENGTH_SHORT).show();}
        //*/

    }

    /**
     * A helper method that alphabetically sorts the Champions by name
     */
    private void sortByName(){

        for(int i = 1; i < champions.length; i++){
            int j = i;
            while(j > 0 && champions[j].compareTo(champions[j - 1]) < 0){
                String temp = champions[j - 1];
                champions[j - 1] = champions[j];
                champions[j] = temp;
                j--;
            }
        }

    }

}
