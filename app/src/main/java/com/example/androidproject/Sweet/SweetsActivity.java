package com.example.androidproject.Sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidproject.Drink.DrinkDet;
import com.example.androidproject.Drink.DrinksActivity;
import com.example.androidproject.R;
import com.example.androidproject.recipes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SweetsActivity extends AppCompatActivity {
    private ArrayList<String> sweetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweets);
        sweetList=new ArrayList<>();
        ArrayAdapter<SweetList> listAdapter = new ArrayAdapter<SweetList>(this,
                android.R.layout.simple_list_item_1,
                SweetList.sweetsList);

        ListView listView = findViewById(R.id.sweets_list);
        listView.setAdapter(listAdapter);

        // Get a reference to the firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference drinksRef = database.getReference("sweets");
        DatabaseReference recipesRef = database.getReference("recipes");
        // Add ValueEventListener to the reference
        recipesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot recipeSnapshot : dataSnapshot.getChildren()) {
                    recipes recipe = recipeSnapshot.getValue(recipes.class);
                    // check if the recipe type is drink
                    if(recipe.getRecipe_category().equals("sweet")) {
                        sweetList.add(recipe.getRecipe_name());
                    }
                }
                // Set the adapter to the ListView
                ArrayAdapter adapter = new ArrayAdapter(SweetsActivity.this, android.R.layout.simple_list_item_1, sweetList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SweetsActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        // save to firebase
        for (SweetDet sweetDet : SweetDet.sweets) {
            drinksRef.child(sweetDet.getSweet_name()).setValue(sweetDet);
        }
        //read from firebase
        drinksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                sweetList.clear();
                for (DataSnapshot sweetSnapshot : dataSnapshot.getChildren()) {
                    SweetDet sweetDet = sweetSnapshot.getValue(SweetDet.class);
                    sweetList.add(sweetDet.getSweet_name());
                }
                // Set the  adapter to the ListView
                ArrayAdapter adapter = new ArrayAdapter(SweetsActivity.this, android.R.layout.simple_list_item_1, sweetList);

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SweetsActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                Intent intent = new Intent(SweetsActivity.this,
                        SweetsDetailActivity.class);
                intent.putExtra("sweet_id", (int)id);
                startActivity(intent);

            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
}