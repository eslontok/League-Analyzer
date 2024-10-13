package com.example.leagueanalyzer;

/**
 * Game class creates Game objects
 * @author Earl Lontok
 */
public class Game {

    private String championName;
    private String role;
    private int gameDuration;
    private int farm;
    private int kills;
    private int deaths;
    private int assists;
    private int totalTeamKills;
    private boolean victory;

    /**
     * Constructor for the Game class
     * @param championName name of the Champion played in the Game
     * @param role role of the Champion played in the Game
     * @param gameDuration duration of the Game
     * @param farm farm of the Champion played in the Game
     * @param kills kills of the Champion played in the Game
     * @param deaths deaths of the Champion played in the Game
     * @param assists assists of the Champion played in the Game
     * @param totalTeamKills total team kills of the Game
     * @param victory true if the Game was won, false otherwise
     */
    public Game(String championName, String role, int gameDuration, int farm, int kills, int deaths, int assists, int totalTeamKills, boolean victory){
        this.championName = championName;
        this.role = role;
        this.gameDuration = gameDuration;
        this.farm = farm;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.totalTeamKills = totalTeamKills;
        this.victory = victory;
    }

    /**
     * Converts the Game object into a String
     * @return the Game object as a String
     */
    @Override
    public String toString(){

        if(this.victory){
            return "VICTORY" + " | " + this.gameDuration + " minutes\n"
                    + this.championName + " | KDA: " + this.kills + "/" + this.deaths + "/" + this.assists + " | Farm: " + this.farm;
        }
        return "DEFEAT" + " | " + this.gameDuration + " minutes\n"
                + this.championName + " | KDA: " + this.kills + "/" + this.deaths + "/" + this.assists + " | Farm: " + this.farm;

    }

    /**
     * Gets the name of the Champion played in the Game
     * @return the name of the Champion played in the Game
     */
    public String getChampionName(){
        return this.championName;
    }

    /**
     * Gets the role of the Champion played in the Game
     * @return the role of the Champion played in the Game
     */
    public String getRole(){
        return this.role;
    }

    /**
     * Gets the duration of the Game
     * @return the duration of the Game
     */
    public int getGameDuration(){
        return this.gameDuration;
    }

    /**
     * Gets the farm of the Champion played in the Game
     * @return the farm of the Champion played in the Game
     */
    public int getFarm(){
        return this.farm;
    }

    /**
     * Gets the kills of the Champion played in the Game
     * @return the kills of the Champion played in the Game
     */
    public int getKills(){
        return this.kills;
    }

    /**
     * Gets the deaths of the Champion played in the Game
     * @return the deaths of the Champion played in the Game
     */
    public int getDeaths(){
        return this.deaths;
    }

    /**
     * Gets the assists of the Champion played in the Game
     * @return the assists of the Champion played in the Game
     */
    public int getAssists(){
        return this.assists;
    }

    /**
     * Gets the total team kills of the Game
     * @return the total team kills of the Game
     */
    public int getTotalTeamKills(){
        return this.totalTeamKills;
    }

    /**
     * Gets the outcome of the Game (true for victory, false for defeat)
     * @return the outcome of the Game (true for victory, false for defeat)
     */
    public boolean getVictory(){
        return this.victory;
    }

}
