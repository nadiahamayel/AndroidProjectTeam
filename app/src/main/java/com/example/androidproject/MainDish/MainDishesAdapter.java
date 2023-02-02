package com.example.androidproject.MainDish;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;

public class MainDishesAdapter extends RecyclerView.Adapter<MainDishesAdapter.ViewHolder> {

    private String[] names;
    private String[] time;
    private String[] description;
    private int[] imageIds;
    Context context ;

    public MainDishesAdapter(String[] captions, int[] imageIds , Context context){
        this.names = captions;
        this.imageIds = imageIds;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main_dish_recycler,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;

        ImageView imageView =cardView.findViewById(R.id.dish_image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(dr);


        TextView dishName = cardView.findViewById(R.id.dish_name);
        dishName.setText(names[position]);

//        TextView dishTime = cardView.findViewById(R.id.mainDishesTime);
//        dishName.setText(captions[position]);


//        TextView txt2 = cardView.findViewById(R.id.mainDishesDesc);
//        txt2.setText(captions[po]);
//        TextView txt3 = cardView.findViewById(R.id.mainDishesTime);


        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){

//                CharSequence text = "Hello toast!";
//                int duration = Toast.LENGTH_SHORT;
//
//                Toast toast = Toast.makeText(v.getContext(), text, duration);
//                toast.show();

                Intent intent = new Intent(context, MainDishesActivityDetails.class);
                intent.putExtra("mainDish_name",dishName.getText().toString());
               // intent.putExtra("mainDish_time" ,dishTime.getImageTintList());
                context.startActivity(intent);




            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
