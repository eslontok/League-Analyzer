package com.example.leagueanalyzer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * ChampionsAdapter class serves as the adapter for the champions RecyclerView in the ChampionsActivity class
 * @author Earl Lontok
 */
public class ChampionsAdapter extends RecyclerView.Adapter<ChampionsAdapter.ChampionHolder> {

    private Context context;
    private ArrayList<Champion> champions;

    /**
     * Constructor for the ChampionsAdapter class
     * @param context the context of interest
     * @param champions the list of Champions to be added to the champions RecyclerView
     */
    public ChampionsAdapter(Context context, ArrayList<Champion> champions){
        this.context = context;
        this.champions = champions;
    }

    /**
     * Creates a view holder for the Champions
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     * @return the view holder for the Champions
     */
    @NonNull
    @Override
    public ChampionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_champion, parent, false);
        return new ChampionHolder(view);
    }

    /**
     * Binds the view holder for the Champions and the proper data associated to each Champion
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ChampionHolder holder, int position) {
        String name = champions.get(position).getName();
        int imageID = findImageID(name);
        String role = champions.get(position).getRole();
        holder.setData(imageID, name, role);
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
     * Gets the number of items in the champions ArrayList
     * @return the number of items in the champions ArrayList
     */
    @Override
    public int getItemCount(){
        return champions.size();
    }

    /**
     * ChampionHolder class creates ChampionHolder objects
     */
    public class ChampionHolder extends RecyclerView.ViewHolder{

        private ImageView championImage;
        private TextView championName;
        private TextView championRole;

        /**
         * Constructor for the ChampionHolder class
         * @param championView the champion view of interest
         */
        public ChampionHolder(@NonNull View championView){

            super(championView);
            championImage = championView.findViewById(R.id.championIconView);
            championName = championView.findViewById(R.id.championNameView);
            championRole = championView.findViewById(R.id.championRoleView);

            championView.setOnClickListener(new View.OnClickListener(){

                /**
                 * Launches the ChampionOverviewActivity class when a Champion from the champions RecyclerView is clicked
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(context, ChampionOverviewActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("name", championName.getText());
                        intent.putExtra("role", championRole.getText());
                        intent.putExtra("attributes", findChampion(championName.getText().toString()).getAttributes());
                        intent.putExtra("abilities", findChampion(championName.getText().toString()).getAbilities());
                        context.startActivity(intent);
                    }
                }

                /**
                 * A helper method that finds the Champion object of interest in the champions ArrayList
                 * @param name the champion name of interest
                 * @return the Champion object of interest
                 */
                private Champion findChampion(String name){
                    for(int i = 0; i < champions.size(); i++){
                        if(champions.get(i).getName().equals(name)){
                            return champions.get(i);
                        }
                    }
                    return null;
                }

            });

        }

        /**
         * Sets the data for each Champion in the champions RecyclerView
         * @param imageID the proper Champion imageID (champion icon)
         * @param name the proper Champion name
         * @param role the proper Champion role
         */
        public void setData(int imageID, String name, String role){
            championImage.setImageResource(imageID);
            championName.setText(name);
            championRole.setText(role);
        }

    }

}
