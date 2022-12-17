package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePassword extends AppCompatActivity {

    Button save;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        cancel = (Button) findViewById(R.id.btnCancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePassword.this, Profile.class);
                startActivity(intent);
            }
        });


//
//        listview = findViewById(R.id.lstUserInfo);
//
//        ArrayList<InfoListItem> arrayList = new ArrayList<>();
//
//        arrayList.add(new InfoListItem(R.drawable.username, "Username", "test username"));
//        arrayList.add(new InfoListItem(R.drawable.email, "Email", "test email"));
//        arrayList.add(new InfoListItem(R.drawable.date, "Date of Birth", "12/12/2022"));
//        arrayList.add(new InfoListItem(R.drawable.gender, "Gender", "Female"));
//        arrayList.add(new InfoListItem(R.drawable.password, "Password", "123@user1"));

    }
}