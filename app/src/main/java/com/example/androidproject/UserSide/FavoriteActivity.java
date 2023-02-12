package com.example.androidproject.UserSide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidproject.Drink.DrinkDet;
import com.example.androidproject.Drink.DrinksActivity;
import com.example.androidproject.Drink.DrinksList;
import com.example.androidproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    private ArrayList<String> favoritesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        favoritesList = new ArrayList<>();
        ArrayAdapter<DrinksList> listAdapter = new ArrayAdapter<DrinksList>(this,
                android.R.layout.simple_list_item_1);

        ListView listView = findViewById(R.id.favoritesList);
        listView.setAdapter(listAdapter);
        // Get a reference to the firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference drinksRef = database.getReference("favorites");

        //read from firebase
        drinksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                favoritesList.clear();
                for (DataSnapshot drinkSnapshot : dataSnapshot.getChildren()) {
                    DrinkDet drink = drinkSnapshot.getValue(DrinkDet.class);
                    favoritesList.add(drink.getName());
                }
                // Set the  adapter to the ListView
                ArrayAdapter adapter = new ArrayAdapter(FavoriteActivity.this, android.R.layout.simple_list_item_1, favoritesList);

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(FavoriteActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}