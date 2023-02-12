package com.example.androidproject.Drink;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidproject.R;
import com.example.androidproject.recipes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {
    //
    private ArrayList<String> drinkList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        drinkList = new ArrayList<>();
        ArrayAdapter<DrinksList> listAdapter = new ArrayAdapter<DrinksList>(this,
                android.R.layout.simple_list_item_1,
                DrinksList.drinksList);

        ListView listView = findViewById(R.id.drinks_list);
        listView.setAdapter(listAdapter);
        // Get a reference to the firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference drinksRef = database.getReference("drinks");
        DatabaseReference recipesRef = database.getReference("recipes");
        // Add ValueEventListener to the reference
        recipesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot recipeSnapshot : dataSnapshot.getChildren()) {
                    recipes recipe = recipeSnapshot.getValue(recipes.class);
                    // check if the recipe type is drink
                    if(recipe.getRecipe_category().equals("drink")) {
                        drinkList.add(recipe.getRecipe_name());
                    }
                }
                // Set the adapter to the ListView
                ArrayAdapter adapter = new ArrayAdapter(DrinksActivity.this, android.R.layout.simple_list_item_1, drinkList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DrinksActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        // save to firebase
        for (DrinkDet drink : DrinkDet.drinks) {
            drinksRef.child(drink.getName()).setValue(drink);
        }
        //read from firebase
        drinksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                drinkList.clear();
                for (DataSnapshot drinkSnapshot : dataSnapshot.getChildren()) {
                    DrinkDet drink = drinkSnapshot.getValue(DrinkDet.class);
                    drinkList.add(drink.getName());
                }
                // Set the  adapter to the ListView
                ArrayAdapter adapter = new ArrayAdapter(DrinksActivity.this, android.R.layout.simple_list_item_1, drinkList);

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DrinksActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //just for Click
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrinksActivity.this, DrinkDetail.class);
                intent.putExtra("drink_id", (int)id);
                startActivity(intent);



            }
        };
        listView.setOnItemClickListener(itemClickListener);

    }
}