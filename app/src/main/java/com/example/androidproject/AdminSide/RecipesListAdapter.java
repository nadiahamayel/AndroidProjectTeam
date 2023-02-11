package com.example.androidproject.AdminSide;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.androidproject.MainDish.MainDishesActivityDetails;
import com.example.androidproject.MainDish.MainDishesAdapter;
import com.example.androidproject.R;
import com.example.androidproject.RecipesModel;
import com.example.androidproject.fragments.ListRecipesFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

//OnClickListener
public class RecipesListAdapter extends   RecyclerView.Adapter<RecipesListAdapter.ViewHolder>{

//        RecyclerView.Adapter<RecipesListAdapter.ViewHolder> {


    Context context ;
    ArrayList<RecipesModel> list ;
    private OnItemClickListener listener;




    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        listener = clickListener;
    }

    public RecipesListAdapter(Context context, ArrayList<RecipesModel> list) {
        super();

        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_card,parent, false);



        return new ViewHolder(view , listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        RecipesModel model = list.get(position);
        holder.name.setText(model.getRecipe_name());
        holder.time.setText(model.getRecipe_time());

    }
    @Override
    public int getItemCount() {
        return list.size();
    }





    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name , time ;

        ImageView edit , delete ;

        public ViewHolder(@NonNull View itemView , OnItemClickListener listener) {
            super(itemView);


            name = itemView.findViewById(R.id.card_name);
            time = itemView.findViewById(R.id.card_time);

            edit = itemView.findViewById(R.id.editicon);
            delete = itemView.findViewById(R.id.deleteicon);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

//    public DatabaseReference getRef(int position) {
//        return super.getItemViewType(position);
//    }




}
