package com.example.androidproject.MainDish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject.R;

public class MainDishesActivityDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dishes_details);


        Intent intent = getIntent();
        String dishName =(String) intent.getExtras().get("mainDish_name");
        intent.getExtras().get("mainDish_name");

        String dishTime=(String) intent.getExtras().get("mainDish_time");
        intent.getExtras().get("mainDish_time");

      //  MainDishesDet mainDishesDet = MainDishesDet.mainDishes[id];

        ImageView image = findViewById(R.id.mainDishes_image);
       // image.setImageResource(mainDishesDet.getMainDishes_imageID());

        TextView txtName= findViewById(R.id.mainDishesName);
        TextView txtTime= findViewById(R.id.mainDishesTime);
        TextView txtDesc= findViewById(R.id.mainDishesDesc);

        txtName.setText("Main Dish Name : "+dishName);
     //   txtTime.setText("Main Dish Time :" +dishTime);
    //    txtDesc.setText("Main Dish Description : "+mainDishesDet.getMainDishes_description());
    //    txtTime.setText("Main Dish Time : "+mainDishesDet.getMainDishes_time() + "min");
    }
}