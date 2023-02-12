package com.example.androidproject.AdminSide;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

//OnClickListener
public class RecipesListAdapter extends RecyclerView.Adapter<RecipesListAdapter.MyViewHolder> {

    Context context;
    ArrayList<RecipesModel> list;
    private AdapterView.OnItemClickListener listener;

//    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("/recipes/recipe");

    private OnItemClick onItemClick;


    public interface OnItemClick {
        void onItemClick(int position);
    }

    public RecipesListAdapter(Context mContext, ArrayList<RecipesModel> mData, OnItemClick onItemClick) {
        this.context = mContext;
        this.list = mData;
        this.onItemClick = onItemClick;
    }


    public void setOnItemClickListener(AdapterView.OnItemClickListener clickListener) {
        listener = clickListener;
    }

    public RecipesListAdapter(Context context, ArrayList<RecipesModel> list) {
        super();

        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_card, parent, false);


        return new MyViewHolder(view, (OnItemClick) listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        RecipesModel model = list.get(position);
        holder.name.setText(model.getRecipe_name());
        holder.time.setText(model.getRecipe_time());
        //Delete from Firebase and ArrayList
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getPosition();
                RecipesModel recipe = list.get(position);
                list.remove(position);

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("/recipe").child("recipes");
                reference.child(recipe.getRecipe_id()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("Firebase", "Data successfully deleted");

                        } else {
                            Log.d("Firebase", "Data deletion failed");
                        }
                    }
                });
                notifyItemRemoved(position);
            }



        });


        //Edit
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(view.getContext())
                        .setContentHolder(new ViewHolder(R.layout.edit_dialogcontent))
                        .setExpanded(true,1100)
                        .create();

                View myview=dialogPlus.getHolderView();
                final EditText name=myview.findViewById(R.id.name);
                final EditText time=myview.findViewById(androidx.core.R.id.time);
                final EditText description=myview.findViewById(R.id.description);
                final EditText category=myview.findViewById(R.id.category);
                Button submit=myview.findViewById(R.id.edit);


                name.setText(model.getRecipe_name());
                time.setText(model.getRecipe_time());
                description.setText(model.getRecipe_description());
                category.setText(model.getRecipe_category());



                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
//                        map.put("purl",purl.getText().toString());
//                        map.put("name",name.getText().toString());
//                        map.put("email",email.getText().toString());
//                        map.put("course",course.getText().toString());
//
//                        FirebaseDatabase.getInstance().getReference().child("/recipe").child("recipes")
//                                .child(getRef(position).getKey()).updateChildren(map)
//                                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void aVoid) {
//                                        dialogPlus.dismiss();
//                                    }
//                                })
//                                .addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        dialogPlus.dismiss();
//                                    }
//                                });
                    }
                });


            }
        });

    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, time;

        ImageView edit, delete;

        private OnItemClick listener;

        public MyViewHolder(@NonNull View itemView, OnItemClick listener) {

            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);

            name = itemView.findViewById(R.id.card_name);
            time = itemView.findViewById(R.id.card_time);

            edit = itemView.findViewById(R.id.editicon);
            delete = itemView.findViewById(R.id.deleteicon);

//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//                    Query query = ref.child("/recipes");
//
//                    query.addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            int counter = 0;
//                            System.out.println( " the value is " +dataSnapshot);
//                            dataSnapshot.getRef().removeValue();
//                            list.remove(dataSnapshot);
//                            //list.clear();
//                            Toast.makeText(delete.getContext(), null + " Deleted yeees" + counter++, Toast.LENGTH_SHORT).show();
//
//
//                            RecipesListAdapter adapter = new RecipesListAdapter(context, list);
//                            adapter.notifyItemRemoved(getPosition());
//
//
//
//
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            Toast.makeText(delete.getContext(), null + " doesn't work :(", Toast.LENGTH_SHORT).show();
//
//                        }
//                    });
//                }
//            });

        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getPosition());
        }
    }


}
