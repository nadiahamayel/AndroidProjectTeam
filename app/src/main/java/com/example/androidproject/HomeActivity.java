package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                if(position == 0){
                    Intent intent = new Intent(HomeActivity.this, DrinksActivity.class);
                    startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(HomeActivity.this, SweetsActivity.class);
                    startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(HomeActivity.this, MainDishesActivity.class);
                    startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(HomeActivity.this, SideDishesActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = findViewById(R.id.main_menu);
        listView.setOnItemClickListener(itemClickListener);
    }
}