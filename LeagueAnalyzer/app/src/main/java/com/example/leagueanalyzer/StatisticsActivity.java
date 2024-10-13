package com.example.leagueanalyzer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * StatisticsActivity class serves as the controller for the Statistics screen
 * @author Earl Lontok
 */
public class StatisticsActivity extends AppCompatActivity {

    private DecimalFormat decForm = new DecimalFormat("#,###.00");

    ListView gamesListView;
    TextView winRate;
    TextView averageKDA;
    TextView preferredRole;
    TextView performance;

    /**
     * Sets the layout to activity_statistics.xml (displays the Statistics screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        ArrayList<Game> games = MainActivity.games;

        gamesListView = findViewById(R.id.gamesListView);
        winRate = findViewById(R.id.winRate);
        averageKDA = findViewById(R.id.averageKDA);
        preferredRole = findViewById(R.id.preferredRole);
        performance = findViewById(R.id.performance);

        ArrayAdapter<Game> gamesArrayAdapter = new ArrayAdapter<>(this, R.layout.view_games, R.id.gameView, MainActivity.games);
        gamesListView.setAdapter(gamesArrayAdapter);

        winRate.setText(calculateWinRate());
        averageKDA.setText(calculateAverageKDA());
        preferredRole.setText(determinePreferredRole());
        performance.setText(determinePerformance());

        //if a Game is clicked, the user has the option to delete it
        gamesListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            /**
             * Deletes the selected Game if "Yes", does nothing if "No"
             * @param parent The AdapterView where the click happened.
             * @param view The view within the AdapterView that was clicked (this
             *            will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Game game = (Game)parent.getItemAtPosition(position);
                AlertDialog.Builder alert = new AlertDialog.Builder(parent.getContext());
                alert.setTitle("Delete Game");
                alert.setMessage("Do you want to delete this game?");
                //anonymous inner class to handle the onClick event of YES or NO.
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    /**
                     * Deletes the selected Game ("Yes")
                     * @param dialog the dialog that received the click
                     * @param which the button that was clicked (ex.
                     *              {@link DialogInterface#BUTTON_POSITIVE}) or the position
                     *              of the item clicked
                     */
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(getApplicationContext(), "Game deleted.", Toast.LENGTH_SHORT).show();
                        games.remove(game);
                        gamesArrayAdapter.remove(game);
                        gamesListView.setAdapter(gamesArrayAdapter);

                        winRate.setText(calculateWinRate());
                        averageKDA.setText(calculateAverageKDA());
                        preferredRole.setText(determinePreferredRole());
                        performance.setText(determinePerformance());
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener(){
                    /**
                     * Does nothing ("No")
                     * @param dialog the dialog that received the click
                     * @param which the button that was clicked (ex.
                     *              {@link DialogInterface#BUTTON_POSITIVE}) or the position
                     *              of the item clicked
                     */
                    public void onClick(DialogInterface dialog, int which){
                        //do nothing
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });

    }

    /**
     * A helper method that calculates the win rate
     * @return the win rate
     */
    private String calculateWinRate(){

        ArrayList<Game> games = MainActivity.games;
        if(games.size() == 0){
            return "N/A";
        }
        double numWins = 0;
        double totalGames = games.size();
        for(int i = 0; i < games.size(); i++){
            if(games.get(i).getVictory()){
                numWins++;
            }
        }
        return decForm.format(numWins / totalGames * 100) + "%";

    }

    /**
     * A helper method that calculates the average KDA (kills deaths assists)
     * @return the average KDA
     */
    private String calculateAverageKDA(){

        ArrayList<Game> games = MainActivity.games;
        if(games.size() == 0){
            return "N/A";
        }
        double kills = 0;
        double deaths = 0;
        double assists = 0;
        for(int i = 0; i < games.size(); i++){
            kills += games.get(i).getKills();
            deaths += games.get(i).getDeaths();
            assists += games.get(i).getAssists();
        }
        if(deaths == 0){
            return "INFINITE";
        }
        return decForm.format((kills + assists) / deaths);

    }

    /**
     * A helper method that determines the preferred role
     * @return the preferred role
     */
    private String determinePreferredRole(){

        ArrayList<Game> games = MainActivity.games;
        if(games.size() == 0){
            return "N/A";
        }
        HashMap<String, Integer> roles = new HashMap<>();
        for(int i = 0; i < games.size(); i++){
            String role = games.get(i).getRole();
            if(roles.containsKey(role)){
                roles.put(role, roles.get(role) + 1);
            }else{
                roles.put(role, 1);
            }
        }
        int maxFreq = 0;
        String prefRole = null;
        for(String r: roles.keySet()){
            if(roles.get(r) > maxFreq){
                maxFreq = roles.get(r);
                prefRole = r;
            }
        }
        return prefRole;

    }

    /**
     * A helper method that determines the overall performance
     * @return the overall performance
     */
    private String determinePerformance(){

        ArrayList<Game> games = MainActivity.games;
        if(games.size() == 0){
            return "N/A";
        }

        double[] kda = sumKDA(games);
        double totalFarm = sumFarm(games);
        double totalTeamKills = sumTotalTeamKills(games);
        double totalGameDuration = sumGameDuration(games);
        double totalWins = sumWins(games);

        double averageKDA = 0; //determine average KDA
        if(kda[1] == 0){
            averageKDA = Constant.INFINITE;
        }else{
            averageKDA = (kda[0] + kda[2]) / kda[1];
        }

        double killParticipation = 0; //determine kill participation
        if(totalTeamKills != 0){
            killParticipation = (kda[0] + kda[2]) / totalTeamKills;
        }

        double farmPerMinute = 0; //determine farm per minute
        if(totalGameDuration != 0){
            farmPerMinute = totalFarm / totalGameDuration;
        }

        double winRate = (totalWins / games.size()) * 100; //determine win rate

        double totalPoints = calculatePoints(averageKDA, totalTeamKills, killParticipation, farmPerMinute, winRate, totalGameDuration);

        if(totalPoints >= 90){
            return "S";
        }else if(totalPoints >= 80){
            return "A";
        }else if(totalPoints >= 70){
            return "B";
        }else if(totalPoints >= 60){
            return "C";
        }
        return "D";

    }

    /**
     * A helper method that calculates the points earned based on KDA, kill participation, farm per minute, and win rate
     * @param averageKDA the average KDA
     * @param totalTeamKills the total team kills
     * @param killParticipation the kill participation
     * @param farmPerMinute the farm per minute
     * @param winRate the win rate
     * @return the points earned
     */
    private double calculatePoints(double averageKDA, double totalTeamKills, double killParticipation, double farmPerMinute, double winRate, double totalGameDuration){

        ArrayList<Game> games = MainActivity.games;
        double totalPoints = 0;

        //determine points based on averageKDA
        if((averageKDA == Constant.INFINITE && killParticipation >= 0.30) || averageKDA >= (totalTeamKills / games.size()) * (0.30)){
            totalPoints += 100;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 2){
            totalPoints += 95;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 3){
            totalPoints += 90;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 4){
            totalPoints += 85;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 5){
            totalPoints += 80;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 6){
            totalPoints += 75;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 7){
            totalPoints += 70;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 8){
            totalPoints += 65;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 9){
            totalPoints += 60;
        }else if(averageKDA >= (totalTeamKills / games.size()) * 0.30 / 10){
            totalPoints += 55;
        }else{
            totalPoints += 50;
        }

        //determine points based on kill participation
        if(killParticipation >= 0.5){
            totalPoints += 100;
        }else if(killParticipation >= 0.45){
            totalPoints += 90;
        }else if(killParticipation >= 0.40){
            totalPoints += 80;
        }else if(killParticipation >= 0.35){
            totalPoints += 70;
        }else if(killParticipation >= 0.30){
            totalPoints += 60;
        }else {
            totalPoints += 50;
        }

        //determine points based on farm per minute
        if(farmPerMinute >= 9.0){
            totalPoints += 100;
        }else if(farmPerMinute >= 8.5){
            totalPoints += 95;
        }else if(farmPerMinute >= 8.0){
            totalPoints += 90;
        }else if(farmPerMinute >= 7.5){
            totalPoints += 85;
        }else if(farmPerMinute >= 7.0){
            totalPoints += 80;
        }else if(farmPerMinute >= 6.5){
            totalPoints += 75;
        }else if(farmPerMinute >= 6.0){
            totalPoints += 70;
        }else if(farmPerMinute >= 5.5){
            totalPoints += 65;
        }else if(farmPerMinute >= 5.0){
            totalPoints += 60;
        }else if(farmPerMinute >= 4.5){
            totalPoints += 55;
        }else{
            totalPoints += 50;
        }

        //determine points based on win rate
        if(winRate > 60){
            totalPoints += 100;
        }else if(winRate > 55){
            totalPoints += 90;
        }else if(winRate > 50){
            totalPoints += 80;
        }else if(winRate > 45){
            totalPoints += 70;
        }else if(winRate > 40){
            totalPoints += 60;
        }else{
            totalPoints += 50;
        }

        if(totalGameDuration == 0){ //all games played were SUPPORT (cs/min does not matter)
            return totalPoints / 3;
        }
        return totalPoints / 4; //there are 4 factors that determine total points

    }

    /**
     * A helper method that determines the total number of kills, deaths, and assists
     * @param games the list of Games played
     * @return the total number of kills, deaths, and assists
     */
    private double[] sumKDA(ArrayList<Game> games){

        double[] kda = new double[3];
        for(int i = 0; i < games.size(); i++){
            kda[0] += games.get(i).getKills();
            kda[1] += games.get(i).getDeaths();
            kda[2] += games.get(i).getAssists();
        }
        return kda;

    }

    /**
     * A helper method that determines the total farm
     * @param games the list of Games played
     * @return the total farm
     */
    private double sumFarm(ArrayList<Game> games){

        double totalFarm = 0;
        for(int i = 0; i < games.size(); i++){
            if(!games.get(i).getRole().equals("SUPPORT")) {
                totalFarm += games.get(i).getFarm();
            }
        }
        return totalFarm;

    }

    /**
     * A helper method that determines the total number of team kills
     * @param games the list of Games played
     * @return the total number of team kills
     */
    private double sumTotalTeamKills(ArrayList<Game> games){

        double totalTeamKills = 0;
        for(int i = 0; i < games.size(); i++){
            totalTeamKills += games.get(i).getTotalTeamKills();
        }
        return totalTeamKills;

    }

    /**
     * A helper method that determines the total game duration
     * @param games the list of Games played
     * @return the total game duration
     */
    private double sumGameDuration(ArrayList<Game> games){

        double totalGameDuration = 0;
        for(int i = 0; i < games.size(); i++){
            if(!games.get(i).getRole().equals("SUPPORT")){
                totalGameDuration += games.get(i).getGameDuration();
            }
        }
        return totalGameDuration;

    }

    /**
     * A helper method that determines the total number of wins
     * @param games the list of Games played
     * @return the total number of wins
     */
    private double sumWins(ArrayList<Game> games){

        double totalWins = 0;
        for(int i = 0; i < games.size(); i++){
            if(games.get(i).getVictory()){
                totalWins++;
            }
        }
        return totalWins;

    }

    /**
     * Launches the ChampionStatisticsActivity class when the View Champion Statistics button is clicked
     * @param view the view of interest
     */
    public void showActivityChampionStatistics(View view){

        ArrayList<Game> games = MainActivity.games;
        if(games.size() == 0){
            Toast.makeText(getApplicationContext(), "No games played.", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, ChampionStatisticsActivity.class);
            startActivity(intent);
        }

    }

}
