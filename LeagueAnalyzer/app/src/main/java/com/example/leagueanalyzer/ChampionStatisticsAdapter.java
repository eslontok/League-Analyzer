package com.example.leagueanalyzer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * ChampionStatisticsAdapter class serves as the adapter for the championStatistics RecyclerView in the ChampionStatisticsActivity class
 */
public class ChampionStatisticsAdapter extends RecyclerView.Adapter<ChampionStatisticsAdapter.ChampionStatsHolder>{

    private DecimalFormat decForm = new DecimalFormat("#,###.00");
    private DecimalFormat decFormKDA = new DecimalFormat("#,###.0");
    private Context context;
    private ArrayList<ChampionStats> championStats;

    /**
     * Constructor for the ChampionStatisticsAdapter class
     * @param context the context of interest
     * @param championStats the list of ChampionStats to be added to the championStatistics RecyclerView
     */
    public ChampionStatisticsAdapter(Context context, ArrayList<ChampionStats> championStats){
        this.context = context;
        this.championStats = championStats;
    }

    /**
     * Creates a view holder for the ChampionStats
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     * @return the view holder for the ChampionStats
     */
    @NonNull
    @Override
    public ChampionStatsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_champion_statistics, parent, false);
        return new ChampionStatsHolder(view);
    }

    /**
     * Binds the view holder for the ChampionStats and the proper data associated to each ChampionStats
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ChampionStatsHolder holder, int position){
        ChampionStats curr = championStats.get(position);
        String name = curr.getName();
        int imageID = findImageID(name);
        String winRate = decForm.format((double)(curr.getGamesWon()) / (double)(curr.getNumGames()) * 100) + "%";

        String averageKills = decFormKDA.format((double)(curr.getKda()[0]) / (double)(curr.getNumGames()));
        String averageDeaths = decFormKDA.format((double)(curr.getKda()[1]) / (double)(curr.getNumGames()));
        String averageAssists = decFormKDA.format((double)(curr.getKda()[2]) / (double)(curr.getNumGames()));

        String kda = averageKills + "/" + averageDeaths + "/" + averageAssists;
        String csMin = decForm.format((double)(curr.getFarm()) / (double)(curr.getGameDuration()));
        holder.setData(imageID, name, winRate, kda, csMin);
    }

    /**
     * A helper method that finds the proper champion icon image with respect to the champion name
     * @param name the name of the champion
     * @return the proper champion icon image
     */
    private int findImageID(String name){

        if(name.equals("Jax")){return R.drawable.jax_icon;}
        if(name.equals("Kha'Zix")){return R.drawable.khazix_icon;}
        if(name.equals("Ahri")){return R.drawable.ahri_icon;}
        if(name.equals("Ezreal")){return R.drawable.ezreal_icon;}
        if(name.equals("Thresh")){return R.drawable.thresh_icon;}

        if(name.equals("Pantheon")){return R.drawable.pantheon_icon;}
        if(name.equals("Hecarim")){return R.drawable.hecarim_icon;}
        if(name.equals("Kassadin")){return R.drawable.kassadin_icon;}
        if(name.equals("Lucian")){return R.drawable.lucian_icon;}
        if(name.equals("Taric")){return R.drawable.taric_icon;}

        if(name.equals("Fiora")){return R.drawable.fiora_icon;}
        if(name.equals("Evelynn")){return R.drawable.evelynn_icon;}
        if(name.equals("Annie")){return R.drawable.annie_icon;}
        if(name.equals("Vayne")){return R.drawable.vayne_icon;}
        if(name.equals("Alistar")){return R.drawable.alistar_icon;}

        if(name.equals("Kled")){return R.drawable.kled_icon;}
        if(name.equals("Amumu")){return R.drawable.amumu_icon;}
        if(name.equals("Leblanc")){return R.drawable.leblanc_icon;}
        if(name.equals("Tristana")){return R.drawable.tristana_icon;}
        if(name.equals("Nautilus")){return R.drawable.nautilus_icon;}

        if(name.equals("Tryndamere")){return R.drawable.tryndamere_icon;}
        if(name.equals("Wukong")){return R.drawable.wukong_icon;}
        if(name.equals("Ryze")){return R.drawable.ryze_icon;}
        if(name.equals("Zeri")){return R.drawable.zeri_icon;}
        if(name.equals("Nami")){return R.drawable.nami_icon;}

        return R.drawable.default_icon;

    }

    /**
     * Gets the number of items in the championStats ArrayList
     * @return the number of items in the championStats ArrayList
     */
    @Override
    public int getItemCount(){
        return championStats.size();
    }

    /**
     * ChampionStatsHolder class creates ChampionStatsHolder objects
     */
    public class ChampionStatsHolder extends RecyclerView.ViewHolder{

        private ImageView championImage;
        private TextView championName;
        private TextView championWinRate;
        private TextView championKDA;
        private TextView championCSmin;

        /**
         * Constructor for the ChampionStatsHolder class
         * @param championStatsView the championStats view of interest
         */
        public ChampionStatsHolder(@NonNull View championStatsView){

            super(championStatsView);
            championImage = championStatsView.findViewById(R.id.championStatisticsIconView);
            championName = championStatsView.findViewById(R.id.championStatisticsNameView);
            championWinRate = championStatsView.findViewById(R.id.championWinRate);
            championKDA = championStatsView.findViewById(R.id.championKDA);
            championCSmin = championStatsView.findViewById(R.id.championCSmin);

        }

        /**
         * Sets the data for each ChampionStats in the championStatistics RecyclerView
         * @param imageID the proper Champion imageID (champion icon)
         * @param name the proper Champion name
         * @param winRate the proper win rate
         * @param kda the proper kda
         * @param csMin the proper cs/min
         */
        public void setData(int imageID, String name, String winRate, String kda, String csMin){

            championImage.setImageResource(imageID);
            championName.setText(name);
            championWinRate.setText(winRate);
            championKDA.setText(kda);
            championCSmin.setText(csMin);

        }

    }

}
