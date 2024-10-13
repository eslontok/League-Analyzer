package com.example.leagueanalyzer;

/**
 * Champion class creates Champion objects
 * @author Earl Lontok
 */
public class Champion {

    private String name;
    private String role;
    private String[] attributes;
    private String[] abilities;

    /**
     * Constructor for the Champion class
     * @param name name of the Champion
     * @param role role of the Champion
     * @param attributes attributes of the Champion
     * @param abilities abilities of the Champion
     */
    public Champion(String name, String role, String[] attributes, String[] abilities){
        this.name = name;
        this.role = role;
        this.attributes = attributes;
        this.abilities = abilities;
    }

    /**
     * Gets the name of the Champion
     * @return the name of the Champion
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the role of the Champion
     * @return the role of the Champion
     */
    public String getRole(){
        return this.role;
    }

    /**
     * Gets the attributes of the Champion
     * @return the attributes of the Champion
     */
    public String[] getAttributes(){
        return this.attributes;
    }

    /**
     * Gets the abilities of the Champion
     * @return the abilities of the Champion
     */
    public String[] getAbilities(){
        return this.abilities;
    }

}
