package com.example.androidproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityAdmin extends AppCompatActivity {

    ListView recipesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        recipesList = findViewById(R.id.recipes_list);

        ArrayList<Recipe> arrayList = new ArrayList<>();

        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));
        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));
        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));
        arrayList.add(new Recipe(R.drawable.bancake, "Pancake", "Fluffy Pankace with honey and butter"));

        RecipeAdapter recipeAdapter = new RecipeAdapter(this, R.layout.activity_recipes_details,arrayList);

        recipesList.setAdapter(recipeAdapter);
    }
}