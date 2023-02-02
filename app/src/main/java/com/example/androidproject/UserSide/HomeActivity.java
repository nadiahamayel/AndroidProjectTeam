package com.example.androidproject.UserSide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.androidproject.Drink.DrinksActivity;
import com.example.androidproject.LoginActivity;
import com.example.androidproject.MainDish.MainDishesActivity;
import com.example.androidproject.R;
import com.example.androidproject.SideDish.SideDishesActivity;
import com.example.androidproject.Sweet.SweetsActivity;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.my_drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

//        drawerLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);
//
//            }
//        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_profile:
                        // Create an Intent to launch the activity
                        Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.nav_chang_password:
                        // Create an Intent to launch the activity
                        Intent intent2 = new Intent(HomeActivity.this, ChangePasswordActivity.class);
                        startActivity(intent2);
                        return true;

                    case R.id.nav_logout:
                        // Create an Intent to launch the activity
                        Intent intent3 = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent3);
                        return true;

                    case R.id.nav_favorite:
                        // Create an Intent to launch the activity
                        Intent intent4 = new Intent(HomeActivity.this, FavoriteActivity.class);
                        startActivity(intent4);
                        return true;

                    default:
                        return false;
                }
            }
        });
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                if (position == 0) {
                    Intent intent = new Intent(HomeActivity.this, DrinksActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(HomeActivity.this, SweetsActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(HomeActivity.this, MainDishesActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(HomeActivity.this, SideDishesActivity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = findViewById(R.id.main_menu);
        listView.setOnItemClickListener(itemClickListener);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}