package com.example.androidproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisteratiomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        EditText firstName;
        EditText lastName;
        EditText address;
        EditText phone;
        Button register;

        firstName = findViewById(R.id.first);
        lastName = findViewById(R.id.secand);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.registration);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }

            private void checkDataEntered() {
                if (isEmpty(firstName)) {
                    firstName.setError("first name is required!");
                }

                if (isEmpty(lastName)) {
                    lastName.setError("Last name is required!");
                }

            }
        });


    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}
