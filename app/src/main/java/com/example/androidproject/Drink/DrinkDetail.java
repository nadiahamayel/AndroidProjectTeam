package com.example.androidproject.Drink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject.R;

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

        txtName.setText("Drink Name : "+drink.getName());
        txtDesc.setText("Drink Description : "+drink.getDescription());
        //TextView just access String , in this case time is integer .
        txtTime.setText("Drink Time : "+drink.getTime() + "min");

    }
}