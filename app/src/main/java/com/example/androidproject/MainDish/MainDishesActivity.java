package com.example.androidproject.MainDish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidproject.R;

public class MainDishesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dishes);

        RecyclerView recycler = findViewById(R.id.main_dish_recycler);

        String[] captions = new String[MainDishesDet.mainDishes.length];
        int[] ids = new int[MainDishesDet.mainDishes.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = MainDishesDet.mainDishes[i].getMainDishes_name();
            ids[i] = MainDishesDet.mainDishes[i].getMainDishes_imageID();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        MainDishesAdapter adapter = new MainDishesAdapter(captions, ids,this);
        recycler.setAdapter(adapter);


    }
}