package com.example.androidproject.UserSide;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidproject.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements LocationListener {

    Button generateLocation;
    TextView locationResult;
    TextView email;
    TextView password;
    TextView username;
    LocationManager locationManager;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        generateLocation = findViewById(R.id.btnGenerateLocation);
        locationResult = findViewById(R.id.location);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        email.setText(currentUser.getEmail());
        password.setText(currentUser.getUid());

        String emailText = email.getText().toString();
        String[] split = emailText.split("@");
        username.setText(split[0]);


        if (ContextCompat.checkSelfPermission(ProfileActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ProfileActivity.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }


        generateLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Intent intent = new Intent(ProfileActivity.this, ChangePasswordActivity.class);
//                startActivity(intent);

                getLocation();
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            Toast.makeText(this, "Please wait, your location is generated!", Toast.LENGTH_SHORT).show();
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5,ProfileActivity.this);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {

        try {
            Geocoder geocoder = new Geocoder(ProfileActivity.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String address = addresses.get(0).getAddressLine(0);

            locationResult.setText(address);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}