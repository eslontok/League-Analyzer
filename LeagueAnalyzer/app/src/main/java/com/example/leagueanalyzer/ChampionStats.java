package com.example.leagueanalyzer;

/**
 * ChampionStats class creates ChampionStats objects
 * @author Earl Lontok
 */
public class ChampionStats {

    private String name;
    private int[] kda;
    private int farm;
    private int gameDuration;
    private int gamesWon;
    private int numGames;

    /**
     * Constructor for the ChampionStats class
     * @param name name of the Champion
     * @param kda total kda of the Champion
     * @param farm total farm of the Champion
     * @param gameDuration total duration of Games played as the Champion
     * @param gamesWon number of Games won as the Champion
     * @param numGames number of Games played as the Champion
     */
    public ChampionStats(String name, int[] kda, int farm, int gameDuration, int gamesWon, int numGames){

        this.name = name;
        this.kda = kda;
        this.farm = farm;
        this.gameDuration = gameDuration;
        this.gamesWon = gamesWon;
        this.numGames = numGames;

    }

    /**
     * Checks if two objects (ChampionStats) are equal with respect to the Champion name
     * @param obj the object of interest (ChampionStats)
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj){

        if(obj instanceof ChampionStats){
            ChampionStats championStats = (ChampionStats)obj;
            if(this.name.equals(championStats.name)){
                return true;
            }
        }
        return false;

    }

    /**
     * Gets the name of the Champion
     * @return the name of the Champion
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the total KDA of the Champion
     * @return the total KDA of the Champion
     */
    public int[] getKda(){
        return this.kda;
    }

    /**
     * Gets the total farm of the Champion
     * @return the total farm of the Champion
     */
    public int getFarm(){
        return this.farm;
    }

    /**
     * Gets the total duration of Games played as the Champion
     * @return the total duration of Games played as the Champion
     */
    public int getGameDuration(){
        return this.gameDuration;
    }

    /**
     * Gets the number of Games won as the Champion
     * @return the number of Games won as the Champion
     */
    public int getGamesWon(){
        return this.gamesWon;
    }

    /**
     * Gets the number of Games played as the Champion
     * @return the number of Games played as the Champion
     */
    public int getNumGames(){
        return this.numGames;
    }

    /**
     * Updates the statistics of the Champion
     * @param kda the KDA of the Champion
     * @param farm the farm of the Champion
     * @param gameDuration the duration of the Game played as the Champion
     * @param gamesWon the number of Games won as the Champion
     * @param numGames the number of Games played as the Champion
     */
    public void updateStats(int[] kda, int farm, int gameDuration, int gamesWon, int numGames){

        this.kda[0] += kda[0];
        this.kda[1] += kda[1];
        this.kda[2] += kda[2];

        this.farm += farm;
        this.gameDuration += gameDuration;
        this.gamesWon += gamesWon;
        this.numGames += numGames;

    }

}
