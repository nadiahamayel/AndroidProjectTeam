package com.example.androidproject.AdminSide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;


//OnClickListener
public class RecipesListAdapter extends RecyclerView.Adapter<RecipesListAdapter.ViewHolder> implements View.OnClickListener {


    private String [] recipe_name;
    //buttons
    Button edit, delete;


    public RecipesListAdapter(String[] recipe_name) {
        this.recipe_name = recipe_name;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recipeslist_fragment,
                parent,
                false);

        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CardView cardView = holder.cardView;


        //buttons

        TextView txt = cardView.findViewById(R.id.recipe_name);
        txt.setText(recipe_name[position]);

        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){

                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Context Context = cardView.getContext();
                Toast toast = Toast.makeText(Context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipe_name.length;
    }

    @Override
    public void onClick(View v) {
        edit = v.findViewById(R.id.editButton);
        delete = v.findViewById(R.id.deleteButton);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
