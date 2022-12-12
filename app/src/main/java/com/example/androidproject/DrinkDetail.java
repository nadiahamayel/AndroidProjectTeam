package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DrinkDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        Intent intent = getIntent();
        int id = (int)intent.getExtras().get("drink_id");

        DrinkDet drink = DrinkDet.drinks[id];

        ImageView image = findViewById(R.id.coffee_image);
        image.setImageResource(drink.getImageID());

        TextView txtName= findViewById(R.id.txtName);
        TextView txtTime= findViewById(R.id.txtTime);
        TextView txtDesc= findViewById(R.id.txtDesc);

        txtName.setText(drink.getName());
        txtDesc.setText(drink.getDescription());


//        ArrayAdapter<DrinkDet> listAdapter = new ArrayAdapter<DrinkDet>(this,
//                android.R.layout.simple_list_item_1,
//                DrinkDet.drinks);
//
//        ListView listView = findViewById(R.id.drinks_list);
//        listView.setAdapter(listAdapter);
//
//        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent,
//                                    View view,
//                                    int position,
//                                    long id) {
//                Intent intent = new Intent(DrinksActivity.this,
//                        DrinkDetail.class);
//                intent.putExtra("drink_id", (int)id);
//                startActivity(intent);
//
//            }
//        };
//        listView.setOnItemClickListener(itemClickListener);
    }
}