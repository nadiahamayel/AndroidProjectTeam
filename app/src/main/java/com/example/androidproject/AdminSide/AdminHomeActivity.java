package com.example.androidproject.AdminSide;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.androidproject.R;
import com.example.androidproject.fragments.ListRecipesFragment;
import com.example.androidproject.fragments.AddFragment;
import com.example.androidproject.fragments.ListUsersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AdminHomeActivity extends AppCompatActivity  {

    BottomNavigationView bottomNavigationView;
    ListRecipesFragment listRecipesFragment = new ListRecipesFragment();
    AddFragment addFragment = new AddFragment();
    ListUsersFragment listUsersFragment = new ListUsersFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        bottomNavigationView.setSelectedItemId(R.id.list);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
            case R.id.list:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, listRecipesFragment).commit();
                return true;

            case R.id.add:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, addFragment).commit();
                return true;

            case R.id.users:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, listUsersFragment).commit();
                return true;
        }
        return false;
            }
        });


    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.list:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
//                return true;
//
//            case R.id.add:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
//                return true;
//
//            case R.id.users:
//                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
//                return true;
//        }
//        return false;
//    }


}