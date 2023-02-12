package com.example.androidproject.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.AdminSide.RecipesListAdapter;
import com.example.androidproject.MainDish.MainDishesActivity;
import com.example.androidproject.MainDish.MainDishesAdapter;
import com.example.androidproject.MainDish.MainDishesDet;
import com.example.androidproject.R;
import com.example.androidproject.RecipesModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//list
public class ListRecipesFragment extends Fragment  implements RecipesListAdapter.OnItemClick {
    RecyclerView recyclerView;
    ArrayList<RecipesModel> list =new ArrayList<>();
    DatabaseReference ref ;
    RecipesListAdapter adapter;

    //object from firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    //object from database reference class , must add child user or recipe
    DatabaseReference reference = database.getReference().child("/recipes/recipe");

    //this reference for get data from database and I don't need to child
    DatabaseReference referenceToGet = database.getReference();
   // DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("recipes");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate the layout of the fragment
        View view = inflater.inflate(R.layout.list_recipes_fragment, container, false);
        recyclerView = view.findViewById(R.id.recipes_list_recyclerview);
        ref = FirebaseDatabase.getInstance().getReference().child("/recipe").child("recipes");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecipesListAdapter(view.getContext(), list);

        recyclerView.setAdapter(adapter);

       //get list of recipes
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){

                    //Toast.makeText(view.getContext(),"yeees",Toast.LENGTH_LONG).show();

                    RecipesModel model = dataSnapshot.getValue(RecipesModel.class);
                    System.out.println(model.getRecipe_name());
                    System.out.println(model.getRecipe_time());
                  //  list.clear();
                    list.add(model);
                    adapter.notifyDataSetChanged();

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getView().getContext(),"Nooo",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }


    @Override
    public void onItemClick(int position) {
        Toast.makeText(getContext(), null + " test on click", Toast.LENGTH_SHORT).show();

    }
}