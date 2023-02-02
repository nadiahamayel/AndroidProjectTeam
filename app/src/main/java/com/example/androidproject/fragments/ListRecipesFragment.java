package com.example.androidproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.androidproject.UserSide.RecipesList;
import com.example.androidproject.AdminSide.RecipesListAdapter;
import com.example.androidproject.R;



//list
public class ListRecipesFragment extends Fragment {
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate the layout of the fragment
        View view = inflater.inflate(R.layout.list_recipes_fragment, container, false);
        recyclerView = view.findViewById(R.id.recipes_list_recyclerview);

        String[] recipes_name = new String[RecipesList.recipesList.length];

        for(int i = 0; i<recipes_name.length;i++){
            recipes_name[i] = RecipesList.recipesList[i].getRecipes_name();

        }
        //Create the LinearLayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        //Set the layout manager to the RecyclerView
        recyclerView.setLayoutManager(layoutManager);
        //setAdapter
        RecipesListAdapter adapter = new RecipesListAdapter(recipes_name);
       //adapters
        recyclerView.setAdapter(adapter);
       // recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}