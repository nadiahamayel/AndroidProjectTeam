package com.example.androidproject.Sweet;

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

public class SweetsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweets_detail);

        Intent intent = getIntent();
        int id = (int)intent.getExtras().get("sweet_id");

        SweetDet sweetDet = SweetDet.sweets[id];

        ImageView image = findViewById(R.id.sweet_image);
        image.setImageResource(sweetDet.getSweet_imageID());

        TextView txtName= findViewById(R.id.sweetName);
        TextView txtTime= findViewById(R.id.sweetTime);
        TextView txtDesc= findViewById(R.id.sweetDesc);

        txtName.setText("Sweet Name : "+sweetDet.getSweet_name());
        txtDesc.setText("Sweet Description : "+sweetDet.getSweet_description());
        txtTime.setText("Sweet Time : "+sweetDet.getSweet_time() + "min");

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
    }
}