package com.example.leagueanalyzer;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ChampionsActivity class serves as the controller for the Champions screen
 * @author Earl Lontok
 */
public class ChampionsActivity extends AppCompatActivity {

    RecyclerView champions;
    private ArrayList<Champion> championsList = new ArrayList<>();

    /**
     * Sets the layout to activity_champions.xml (displays the Champions screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions);
        populateChampionsList();

        champions = findViewById(R.id.championsRecyclerView);
        Log.i(championsList.get(0).toString(), "Function has generated zero.");
        ChampionsAdapter adapter = new ChampionsAdapter(getApplicationContext(), championsList);
        champions.setAdapter(adapter);
        champions.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * A helper method that sets the contents for the RecyclerView champions
     */
    private void populateChampionsList(){

        championsList.add(new Champion("Jax", "FIGHTER", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "DURABLE"}, new String[]{"PASSIVE - gain attack speed", "Q - jump to a target", "W - empower next auto-attack or Q ability", "E - become immune to all auto-attacks and stun enemies", "ULT - auto-attacks deal bonus damage; increase durability",}));
        championsList.add(new Champion("Kha'Zix", "ASSASSIN", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "STEALTH", "SQUISHY"}, new String[]{"PASSIVE - once revealed, first auto-attack on an enemy deals bonus damage and slows", "Q - deal damage to an enemy; isolated enemies take more damage", "W - damage enemies and heal", "E - jump to and damage an area", "ULT - become invisible and gain movement speed",}));
        championsList.add(new Champion("Ahri", "MAGE", new String[]{"RANGED", "HIGH DAMAGE", "MOBILE", "SQUISHY"}, new String[]{"PASSIVE - heal after killing enemies", "Q - throw an orb that deals damage on the way out and on the way back", "W - gain movement speed and homing fox-fires", "E - damage and charm an enemy", "ULT - dash and fire homing essence bolts",}));
        championsList.add(new Champion("Ezreal", "MARKSMAN", new String[]{"RANGED", "HIGH DAMAGE", "MOBILE", "SQUISHY"}, new String[]{"PASSIVE - gain attack speed after landing abilities", "Q - fire a damaging bolt", "W - fire an orb that marks an enemy; attack a marked enemy to proc burst damage", "E - teleport and fire a homing bolt", "ULT - fire a barrage of energy",}));
        championsList.add(new Champion("Thresh", "SUPPORT", new String[]{"RANGED", "CROWD CONTROL", "DURABLE"}, new String[]{"PASSIVE - gain armor and ability power after collecting souls", "Q - hook an enemy", "W - shield and pull an ally", "E - push and slow enemies", "ULT - create a \"box\" that damages and slows enemies",}));

        championsList.add(new Champion("Pantheon", "FIGHTER", new String[]{"MELEE", "HIGH DAMAGE", "DURABLE"}, new String[]{"PASSIVE - empower an ability after 5 auto-attacks", "Q - jab or throw a spear", "W - jump to and stun an enemy", "E - deal damage and become immune to damage in one direction", "ULT - jump high and damage an area",}));
        championsList.add(new Champion("Hecarim", "FIGHTER", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "CROWD CONTROL", "DURABLE"}, new String[]{"PASSIVE - gain attack damage based on movement speed", "Q - deal damage to surrounding enemies", "W - deal damage to surrounding enemies and heal", "E - gain movement speed and knock back an enemy", "ULT - dash and fear enemies",}));
        championsList.add(new Champion("Kassadin", "ASSASSIN", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "DURABLE"}, new String[]{"PASSIVE - take reduced magic damage and ignore unit collision", "Q - damage an enemy and gain a magic shield", "W - empower next auto-attack", "E - damage and slow enemies", "ULT - teleport to and damage an area",}));
        championsList.add(new Champion("Lucian", "MARKSMAN", new String[]{"RANGED", "HIGH DAMAGE", "MOBILE", "SQUISHY"}, new String[]{"PASSIVE - quickly auto-attack twice after using an ability", "Q - deal damage in a line", "W - damage and mark enemies; attack marked enemies to gain movement speed", "E - dash a short distance", "ULT - rapidly shoot in a direction",}));
        championsList.add(new Champion("Taric", "SUPPORT", new String[]{"MELEE", "CROWD CONTROL", "HEALER", "DURABLE"}, new String[]{"PASSIVE - quickly auto-attack twice after using an ability", "Q - heal surrounding allies", "W - shield and connect to an ally; the ally mimics the Q and E ability", "E - damage and stun enemies", "ULT - temporarily grant allies immunity to damage",}));

        championsList.add(new Champion("Fiora", "FIGHTER", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "DURABLE"}, new String[]{"PASSIVE - mark an enemy's side; attack the mark to deal bonus damage, heal, and gain movement speed", "Q - dash and deal damage to an enemy", "W - become immune to damage and stab; slow or stun enemies", "E - empower next 2 auto-attacks", "ULT - mark all sides of an enemy and gain movement speed",}));
        championsList.add(new Champion("Evelynn", "ASSASSIN", new String[]{"MELEE", "HIGH DAMAGE", "CROWD CONTROL", "STEALTH", "SQUISHY"}, new String[]{"PASSIVE - heal when health is low; become camouflaged starting at level 6", "Q - shoot damaging spikes in succession", "W - damage and charm an enemy", "E - dash to and damage enemies", "ULT - deal executing damage and teleport backwards",}));
        championsList.add(new Champion("Annie", "MAGE", new String[]{"RANGED", "HIGH DAMAGE", "CROWD CONTROL", "SQUISHY"}, new String[]{"PASSIVE - every 4th damaging ability stuns enemies", "Q - shoot a damaging blast of fire", "W - shoot flames forward in an area", "E - shield and grant an ally movement speed", "ULT - damage an area with a bear; the bear remains and attacks enemies",}));
        championsList.add(new Champion("Vayne", "MARKSMAN", new String[]{"RANGED", "HIGH DAMAGE", "MOBILE", "STEALTH", "SQUISHY"}, new String[]{"PASSIVE - gain movement speed towards enemies", "Q - dash and empower next auto-attack", "W - every third auto-attack on the same enemy deals bonus damage", "E - knock back an enemy; the enemy is stunned if knocked back against a wall", "ULT - gain movement speed and attack damage; the Q ability grants invisibility",}));
        championsList.add(new Champion("Alistar", "SUPPORT", new String[]{"MELEE", "CROWD CONTROL", "HIGHLY DURABLE"}, new String[]{"PASSIVE - heal nearby allies", "Q - damage and knock up surrounding enemies", "W - dash to and knock back an enemy", "E - damage and apply stacks to an enemy; auto-attack a fully-stacked enemy to stun and deal bonus damage", "ULT - remove all crowd control and increase durability",}));

        championsList.add(new Champion("Kled", "FIGHTER", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "CROWD CONTROL", "DURABLE"}, new String[]{"PASSIVE - ride Skaarl; Skaarl leaves upon taking enough damage", "Q - mounted: damage and pull an enemy; dismounted: fire a gun blast", "W - empower next 4 auto-attacks", "E - mounted: dash through and damage enemies", "ULT - mounted: charge and damage and knock back an enemy",}));
        championsList.add(new Champion("Amumu", "TANK", new String[]{"MELEE", "CROWD CONTROL", "HIGHLY DURABLE"}, new String[]{"PASSIVE - auto-attacks curse enemies; cursed enemies take bonus damage from incoming magic damage", "Q - stun and dash to an enemy", "W - deal continuous damage to surrounding enemies", "E - deal a burst of damage to surrounding enemies", "ULT - damage and stun surrounding enemies",}));
        championsList.add(new Champion("Leblanc", "ASSASSIN", new String[]{"RANGED", "HIGH DAMAGE", "MOBILE", "CROWD CONTROL", "SQUISHY"}, new String[]{"PASSIVE - briefly become invisible and create a decoy upon taking enough damage", "Q - damage and mark an enemy; attack a marked enemy with an ability to proc burst damage", "W - dash to and damage an area; recast to teleport back", "E - damage and root an enemy", "ULT - mimic the Q, W, or E ability",}));
        championsList.add(new Champion("Tristana", "MARKSMAN", new String[]{"RANGED", "HIGH DAMAGE", "MOBILE", "SQUISHY"}, new String[]{"PASSIVE - gain attack range per level", "Q - gain attack speed", "W - jump to and damage and slow an area", "E - killing enemies deals damage to surrounding enemies; place a damaging bomb on an enemy", "ULT - damage and knock back an enemy",}));
        championsList.add(new Champion("Nautilus", "TANK", new String[]{"MELEE", "CROWD CONTROL", "HIGHLY DURABLE"}, new String[]{"PASSIVE - first auto-attack on an enemy deals bonus damage and roots", "Q - hook an enemy", "W - gain a shield and empower auto-attacks", "E - deal damage and slow surrounding enemies", "ULT - fire a homing shockwave that damages and knocks up an enemy; enemies along the path are damaged and knocked up",}));

        championsList.add(new Champion("Tryndamere", "FIGHTER", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "DURABLE"}, new String[]{"PASSIVE - build fury; fury increases critical strike chance", "Q - gain attack damage as health decreases; consume fury and heal", "W - decrease the attack damage of surrounding enemies; slow enemies who are facing away", "E - dash through and damage enemies", "ULT - temporarily become immune to death"}));
        championsList.add(new Champion("Wukong", "FIGHTER", new String[]{"MELEE", "HIGH DAMAGE", "MOBILE", "DURABLE"}, new String[]{"PASSIVE - gain armor", "Q - deal damage and decrease an enemy's armor", "W - dash, become invisible, and create a decoy; the decoy attacks and mimics the Q ability", "E - dash to and damage enemies; gain attack speed", "ULT - rapidly spin and damage and knock up enemies"}));
        championsList.add(new Champion("Ryze", "MAGE", new String[]{"RANGED", "HIGH DAMAGE", "DURABLE"}, new String[]{"PASSIVE - increase mana based on ability power", "Q - fire a damaging charge of energy; deals bonus damage and propagates to enemies affected by the E ability", "W - slow an enemy; roots instead if the enemy is affected by the E ability", "E - damage and mark enemies", "ULT - teleport allies"}));
        championsList.add(new Champion("Zeri", "MARKSMAN", new String[]{"RANGED", "HIGH DAMAGE", "MOBILE", "SQUISHY"}, new String[]{"PASSIVE - gain movement speed when shielded; attack shielded enemies to absorb the shield", "Q - fire a series of rounds", "W - damage and slow enemies in a line", "E - dash and empower next 3 instances of the Q ability", "ULT - deal damage to surrounding enemies and gain increased damage and movement speed; the Q ability chains to nearby enemies"}));
        championsList.add(new Champion("Nami", "SUPPORT", new String[]{"RANGED", "CROWD CONTROL", "HEALER", "SQUISHY"}, new String[]{"PASSIVE - grant allies movement speed", "Q - damage and stun enemies", "W - heal allies and damage enemies", "E - empower an ally's auto-attacks; the empowered auto-attacks deal bonus damage and slow", "ULT - create a tidal wave that damages, knocks up, and slows enemies"}));

        sortByName();

    }

    /**
     * A helper method that alphabetically sorts the Champions by name
     */
    private void sortByName(){

        for(int i = 1; i < championsList.size(); i++){
            int j = i;
            while(j > 0 && championsList.get(j).getName().compareTo(championsList.get(j - 1).getName()) < 0){
                Champion temp = championsList.get(j - 1);
                championsList.set(j - 1, championsList.get(j));
                championsList.set(j, temp);
                j--;
            }
        }

    }

}
