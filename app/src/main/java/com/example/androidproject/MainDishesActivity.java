package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainDishesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dishes);

        RecyclerView recycler = findViewById(R.id.main_dish_recycler);

        String[] captions = new String[MainDishesList.mainDishes.length];
        int[] ids = new int[MainDishesList.mainDishes.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = MainDishesList.mainDishes[i].getDishName();
            ids[i] = MainDishesList.mainDishes[i].getDishImg();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids);
        recycler.setAdapter(adapter);
    }
}