package com.example.androidproject.MainDish;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidproject.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

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

        Button myfavorite = findViewById(R.id.myfavorite);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference favoritesRef = database.getReference("favorites");


        myfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtName = findViewById(R.id.txtName);
                String name = txtName.getText().toString();
                TextView txtTime = findViewById(R.id.txtTime);
                String time = txtTime.getText().toString();
                TextView txtDesc = findViewById(R.id.txtDesc);
                String desc = txtDesc.getText().toString();

                Map<String, Object> favorite = new HashMap<>();
                favorite.put("name", name);
                favorite.put("time", time);
                favorite.put("desc", desc);

                favoritesRef.push().setValue(favorite)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // you can add a toast message to confirm that the item has been added to the favorites list
                                Toast.makeText(getApplicationContext(), "Item added to favorites", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // you can add a toast message to show that there was an error adding the item to the favorites list
                                Toast.makeText(getApplicationContext(), "Error adding item to favorites", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
     //   txtTime.setText("Main Dish Time :" +dishTime);
    //    txtDesc.setText("Main Dish Description : "+mainDishesDet.getMainDishes_description());
    //    txtTime.setText("Main Dish Time : "+mainDishesDet.getMainDishes_time() + "min");
    }
}