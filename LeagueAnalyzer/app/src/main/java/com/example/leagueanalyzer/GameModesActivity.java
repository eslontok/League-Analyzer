package com.example.leagueanalyzer;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * GameModesActivity class serves as the controller for the Game Modes screen
 * @author Earl Lontok
 */
public class GameModesActivity extends AppCompatActivity {

    private ImageView mapImage;
    private Spinner mapSpinner;
    private TextView mapDescription;
    private TextView mapGameModes;

    private String mapName;

    /**
     * Sets the layout to activity_game_modes.xml (displays the Game Modes screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_modes);

        mapImage = findViewById(R.id.mapImage);
        mapSpinner = findViewById(R.id.mapSpinner);
        mapDescription = findViewById(R.id.mapDescription);
        mapGameModes = findViewById(R.id.mapGameModes);

        //the content displayed on the screen changes depending on which map is selected
        mapSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Changes the content displayed depending on which map is selected
             * @param parent The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param position The position of the view in the adapter
             * @param id The row id of the item that is selected
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mapName = mapSpinner.getSelectedItem().toString();

                mapImage.setImageResource(findMapImage(mapName));
                mapDescription.setText(findMapDescription(mapName));
                mapGameModes.setText(findMapGameModes(mapName));
            }

            /**
             * Does nothing if no map is selected
             * @param parent The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //this can be left empty
            }

            /**
             * A helper method that finds the proper map image with respect to the map name
             * @param mapName the name of the map
             * @return the proper map image
             */
            private int findMapImage(String mapName){
                if(mapName.equals("SUMMONER\'S RIFT")){
                    return R.drawable.summoners_rift;
                }else if(mapName.equals("HOWLING ABYSS")){
                    return R.drawable.howling_abyss;
                }
                return R.drawable.teamfight_tactics;
            }

            /**
             * A helper method that finds the proper map description with respect to the map name
             * @param mapName the name of the map
             * @return the proper map description
             */
            private String findMapDescription(String mapName){
                if(mapName.equals("SUMMONER\'S RIFT")){
                    return "The classic 5v5 map. Choose your champion, fight to win your lane, and engage in team fights to destroy the enemy nexus.";
                }else if(mapName.equals("HOWLING ABYSS")){
                    return "Champions are randomly assigned. Assemble in one lane and fight to destroy the enemy nexus.";
                }
                return "Choose your squad of champions that battle on your behalf. Employ strategy to become the last one standing.";
            }

            /**
             * A helper method that finds the proper game modes with respect to the map name
             * @param mapName the name of the map
             * @return the proper game modes
             */
            private String findMapGameModes(String mapName){
                if(mapName.equals("SUMMONER\'S RIFT")){
                    return "BLIND PICK - opponents are revealed after champions are chosen; mirrors allowed\n\n" + "DRAFT PICK - teams take turns choosing a unique champion\n\n" +  "RANKED SOLO/DUO - draft pick; earn league points and climb the ranks; solo or duo\n\n" + "RANKED FLEX - draft pick; earn league points and climb the ranks; no parties of 4";
                }else if(mapName.equals("HOWLING ABYSS")){
                    return "ARAM - champions are randomly assigned; engage in never-ending 5v5 team fights";
                }
                return "NORMAL - play for fun, win or lose\n\n" + "RANKED - earn league points and climb the ranks\n\n" + "HYPER ROLL - fast-paced version of the NORMAL game mode\n\n" + "DOUBLE UP (WORKSHOP) - team up with another player and play against 3 other teams of 2";
            }
        });

        String[] maps = {"SUMMONER\'S RIFT", "HOWLING ABYSS", "TEAMFIGHT TACTICS"};
        ArrayAdapter<String> adapterMaps = new ArrayAdapter<>(this, R.layout.view_maps, R.id.mapNameView, maps);
        mapSpinner.setAdapter(adapterMaps);

    }

}
