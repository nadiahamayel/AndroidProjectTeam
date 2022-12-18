package com.example.androidproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
public class SideDishesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activatiy_side_dishes);

        RecyclerView recycler = findViewById(R.id.side_dish_recycler);

        String[] captions = new String[SideDishes.sideDishes.length];
        int[] ids = new int[SideDishes.sideDishes.length];

        for(int i = 0; i<captions.length;i++){
            captions[i] = SideDishes.sideDishes[i].getSideName();
            ids[i] = SideDishes.sideDishes[i].getSideimg();
        }
        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(captions, ids);
        recycler.setAdapter(adapter);
    }


    }
