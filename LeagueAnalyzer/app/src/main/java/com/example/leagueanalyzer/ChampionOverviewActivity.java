package com.example.leagueanalyzer;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * ChampionOverviewActivity class serves as the controller for the Champion Overview screen
 * @author Earl Lontok
 */
public class ChampionOverviewActivity extends AppCompatActivity {

    private ImageView championImage;
    private TextView championName;
    private TextView championRole;
    private TextView championDescription;
    private ListView championAttributes;
    private ListView championAbilities;

    Bundle extras;

    /**
     * Sets the layout to activity_champion_overview.xml (displays the Champion Overview screen)
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_overview);

        championImage = findViewById(R.id.championImage);
        championName = findViewById(R.id.championName);
        championRole = findViewById(R.id.championRole);
        championDescription = findViewById(R.id.championDescription);
        championAttributes = findViewById(R.id.championAttributes);
        championAbilities = findViewById(R.id.championAbilities);

        extras = getIntent().getExtras();
        String name = extras.getString("name");
        String role = extras.getString("role");

        championImage.setImageResource(findImageID(name));
        championName.setText(name);
        championRole.setText(role);
        championDescription.setText(findChampionDescription(name));

        String[] attributes = extras.getStringArray("attributes");
        ArrayAdapter<String> adapterAttributes = new ArrayAdapter<>(this, R.layout.view_champion_attributes, R.id.championAttributeView, attributes);
        championAttributes.setAdapter(adapterAttributes);

        String[] abilities = extras.getStringArray("abilities");
        ArrayAdapter<String> adapterAbilities = new ArrayAdapter<>(this, R.layout.view_champion_abilities, R.id.championAbilityView, abilities);
        championAbilities.setAdapter(adapterAbilities);

    }

    /**
     * A helper method that finds the proper champion icon image with respect to the champion name
     * @param name the name of the champion
     * @return the proper champion icon image
     */
    private int findImageID(String name){

        if(name.equals("Jax")){return R.drawable.jax_splashart;}
        if(name.equals("Kha'Zix")){return R.drawable.khazix_splashart;}
        if(name.equals("Ahri")){return R.drawable.ahri_splashart;}
        if(name.equals("Ezreal")){return R.drawable.ezreal_splashart;}
        if(name.equals("Thresh")){return R.drawable.thresh_splashart;}

        if(name.equals("Pantheon")){return R.drawable.pantheon_splashart;}
        if(name.equals("Hecarim")){return R.drawable.hecarim_splashart;}
        if(name.equals("Kassadin")){return R.drawable.kassadin_splashart;}
        if(name.equals("Lucian")){return R.drawable.lucian_splashart;}
        if(name.equals("Taric")){return R.drawable.taric_splashart;}

        if(name.equals("Fiora")){return R.drawable.fiora_splashart;}
        if(name.equals("Evelynn")){return R.drawable.evelynn_splashart;}
        if(name.equals("Annie")){return R.drawable.annie_splashart;}
        if(name.equals("Vayne")){return R.drawable.vayne_splashart;}
        if(name.equals("Alistar")){return R.drawable.alistar_splashart;}

        if(name.equals("Kled")){return R.drawable.kled_splashart;}
        if(name.equals("Amumu")){return R.drawable.amumu_splashart;}
        if(name.equals("Leblanc")){return R.drawable.leblanc_splashart;}
        if(name.equals("Tristana")){return R.drawable.tristana_splashart;}
        if(name.equals("Nautilus")){return R.drawable.nautilus_splashart;}

        if(name.equals("Tryndamere")){return R.drawable.tryndamere_splashart;}
        if(name.equals("Wukong")){return R.drawable.wukong_splashart;}
        if(name.equals("Ryze")){return R.drawable.ryze_splashart;}
        if(name.equals("Zeri")){return R.drawable.zeri_splashart;}
        if(name.equals("Nami")){return R.drawable.nami_splashart;}

        return R.drawable.default_icon;

    }

    /**
     * A helper method that finds the proper champion description with respect to the champion name
     * @param name the champion name
     * @return the proper champion description
     */
    private String findChampionDescription(String name){

        if(name.equals("Jax")){return "\"GRANDMASTER AT ARMS\"";}
        if(name.equals("Kha'Zix")){return "\"THE VOIDREAVER\"";}
        if(name.equals("Ahri")){return "\"THE NINE-TAILED FOX\"";}
        if(name.equals("Ezreal")){return "\"THE PRODIGAL EXPLORER\"";}
        if(name.equals("Thresh")){return "\"THE CHAIN WARDEN\"";}

        if(name.equals("Pantheon")){return "\"THE UNBREAKABLE SPEAR\"";}
        if(name.equals("Hecarim")){return "\"THE SHADOW OF WAR\"";}
        if(name.equals("Kassadin")){return "\"THE VOID WALKER\"";}
        if(name.equals("Lucian")){return "\"THE PURIFIER\"";}
        if(name.equals("Taric")){return "\"THE SHIELD OF VALORAN\"";}

        if(name.equals("Fiora")){return "\"THE GRAND DUELIST\"";}
        if(name.equals("Evelynn")){return "\"AGONY'S EMBRACE\"";}
        if(name.equals("Annie")){return "\"THE DARK CHILD\"";}
        if(name.equals("Vayne")){return "\"THE NIGHT HUNTER\"";}
        if(name.equals("Alistar")){return "\"THE MINOTAUR\"";}

        if(name.equals("Kled")){return "\"THE CANTANKEROUS CAVALIER\"";}
        if(name.equals("Amumu")){return "\"THE SAD MUMMY\"";}
        if(name.equals("Leblanc")){return "\"THE DECEIVER\"";}
        if(name.equals("Tristana")){return "\"THE YORDLE GUNNER\"";}
        if(name.equals("Nautilus")){return "\"THE TITAN OF THE DEPTHS\"";}

        if(name.equals("Tryndamere")){return "\"THE BARBARIAN KING\"";}
        if(name.equals("Wukong")){return "\"THE MONKEY KING\"";}
        if(name.equals("Ryze")){return "\"THE RUNE MAGE\"";}
        if(name.equals("Zeri")){return "\"THE SPARK OF ZAUN\"";}
        if(name.equals("Nami")){return "\"THE TIDECALLER\"";}

        return null;

    }

}
