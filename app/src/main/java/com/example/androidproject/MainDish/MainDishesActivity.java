package com.example.androidproject.MainDish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainDishesActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private List<MainDishesDet> mainDishesList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dishes);

        RecyclerView recycler = findViewById(R.id.main_dish_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //read from firebase
        mDatabase = FirebaseDatabase.getInstance().getReference().child("main_dishes");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mainDishesList.clear();
                for (DataSnapshot mainDishesSnapshot : dataSnapshot.getChildren()) {
                    MainDishesDet mainDishes = mainDishesSnapshot.getValue(MainDishesDet.class);
                    mainDishesList.add(mainDishes);
                }
                String[] captions = new String[mainDishesList.size()];
                int[] ids = new int[mainDishesList.size()];
                for (int i = 0; i < mainDishesList.size(); i++) {
                    captions[i] = mainDishesList.get(i).getMainDishes_name();
                    ids[i] = mainDishesList.get(i).getMainDishes_imageID();
                }
                MainDishesAdapter adapter = new MainDishesAdapter(captions, ids, MainDishesActivity.this);
                recycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //save to firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();

        for (int i = 0; i < MainDishesDet.mainDishes.length; i++) {
            mDatabase.child("main_dishes").child(String.valueOf(i))
                    .setValue(MainDishesDet.mainDishes[i]);
        }


    }
}