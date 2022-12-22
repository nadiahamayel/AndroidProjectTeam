package com.example.androidproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.androidproject.R;
import com.example.androidproject.Recipe;
import com.example.androidproject.RecipeAdapter;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    ListView recipesList;

    public FirstFragment() {



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        recipesList = recipesList.findViewById(R.id.recipes_list);

        ArrayList<Recipe> arrayList = new ArrayList<>();

        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));
        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));
        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));
        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));

//        RecipeAdapter recipeAdapter = new RecipeAdapter( getView(R.id.activity_recipes_details).activity_recipes_details,arrayList);
//
//        recipesList.setAdapter(recipeAdapter); // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_first, container, false);
    }
}