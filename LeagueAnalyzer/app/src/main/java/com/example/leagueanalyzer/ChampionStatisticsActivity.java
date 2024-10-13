package com.example.leagueanalyzer;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ChampionStatisticsActivity class serves as the controller for the Champion Statistics screen
 * @author Earl Lontok
 */
public class ChampionStatisticsActivity extends AppCompatActivity {

    RecyclerView championStatistics;
    private ArrayList<ChampionStats> championStatsList = new ArrayList<>();

    /**
     * Sets the layout to activity_champion_statistics.xml (displays the Champion Statistics screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_statistics);
        populateChampionStatsList();

        championStatistics = findViewById(R.id.championStatisticsRecyclerView);
        Log.i(championStatsList.get(0).toString(), "Function has generated zero.");
        ChampionStatisticsAdapter adapter = new ChampionStatisticsAdapter(getApplicationContext(), championStatsList);
        championStatistics.setAdapter(adapter);
        championStatistics.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * A helper method that sets the contents for the RecyclerView championStatistics
     */
    private void populateChampionStatsList(){

        ArrayList<Game> games = MainActivity.games;
        HashMap<String, ChampionStats> hm = new HashMap<>();

        for(int i = 0; i < games.size(); i++){
            Game game = games.get(i);
            String name = game.getChampionName();
            int[] kda = {game.getKills(), game.getDeaths(), game.getAssists()};
            int farm = game.getFarm();
            int gameDuration = game.getGameDuration();

            if(hm.containsKey(name)){
                ChampionStats cs = hm.get(name);
                if(game.getVictory()){
                    cs.updateStats(kda, farm, gameDuration, 1, 1);
                    hm.put(name, cs);
                }else{
                    cs.updateStats(kda, farm, gameDuration, 0, 1);
                    hm.put(name, cs);
                }
            }else{
                if(game.getVictory()){
                    hm.put(name, new ChampionStats(name, kda, farm, gameDuration, 1, 1));
                }else{
                    hm.put(name, new ChampionStats(name, kda, farm, gameDuration, 0, 1));
                }
            }
        }

        for(String s: hm.keySet()){
            championStatsList.add(hm.get(s));
        }
        sortByName();

    }

    /**
     * A helper method that alphabetically sorts the Champion Statistics by name
     */
    private void sortByName(){

        for(int i = 1; i < championStatsList.size(); i++){
            int j = i;
            while(j > 0 && championStatsList.get(j).getName().compareTo(championStatsList.get(j - 1).getName()) < 0){
                ChampionStats temp = championStatsList.get(j - 1);
                championStatsList.set(j - 1, championStatsList.get(j));
                championStatsList.set(j, temp);
                j--;
            }
        }

    }

}
