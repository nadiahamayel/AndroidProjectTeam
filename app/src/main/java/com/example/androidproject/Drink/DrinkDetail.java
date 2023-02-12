package com.example.androidproject.Drink;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidproject.Drink.DrinkDet;
import com.example.androidproject.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

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

        Button myfavorite = findViewById(R.id.myfavorite);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference favoritesRef = database.getReference("favorites");
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        myfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtName = findViewById(R.id.txtName);
                String name = txtName.getText().toString();
                TextView txtTime = findViewById(R.id.txtTime);
                String time = txtTime.getText().toString();
                TextView txtDesc = findViewById(R.id.txtDesc);
                String desc = txtDesc.getText().toString();
                FirebaseUser currentUser = mAuth.getCurrentUser();


                if (currentUser != null) {
                    String userId = currentUser.getUid();
                    Map<String, Object> favorite = new HashMap<>();
                    favorite.put("name", name);
                    favorite.put("time", time);
                    favorite.put("desc", desc);

                    favoritesRef.child("favorites").child(userId).push().setValue(favorite)
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
                } else {
                    // you can add a toast message to show that the user is not logged in
                    Toast.makeText(getApplicationContext(), "Please log in to add to favorites", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}