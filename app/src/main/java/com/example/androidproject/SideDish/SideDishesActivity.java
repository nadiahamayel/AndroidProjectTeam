package com.example.androidproject.SideDish;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidproject.MainDish.MainDishesAdapter;
import com.example.androidproject.MainDish.MainDishesDet;
import com.example.androidproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SideDishesActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private List<SideDishes> sideDishesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activatiy_side_dishes);

        RecyclerView recycler = findViewById(R.id.side_dish_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //read from firebase
        mDatabase = FirebaseDatabase.getInstance().getReference().child("side_dishes");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                sideDishesList.clear();
                for (DataSnapshot sideDishesSnapshot : dataSnapshot.getChildren()) {
                    SideDishes sideDishes = sideDishesSnapshot.getValue(SideDishes.class);
                    sideDishesList.add(sideDishes);
                }
                String[] captions = new String[SideDishes.sideDishes.length];
                int[] ids = new int[SideDishes.sideDishes.length];

                for(int i = 0; i<captions.length;i++){
                    captions[i] = SideDishes.sideDishes[i].getSideName();
                    ids[i] = SideDishes.sideDishes[i].getSideimg();
                }
                MainDishesAdapter adapter = new MainDishesAdapter(captions, ids,SideDishesActivity.this);
                recycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });



        //save to firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();

        for (int i = 0; i < SideDishes.sideDishes.length; i++) {
            mDatabase.child("side_dishes").child(String.valueOf(i))
                    .setValue(SideDishes.sideDishes[i]);
        }
    }


    }
