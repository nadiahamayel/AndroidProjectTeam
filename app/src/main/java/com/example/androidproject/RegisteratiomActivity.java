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
        EditText Name;
        EditText password;
        EditText phone;
        Button register;

        Name = findViewById(R.id.first);

        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        register = findViewById(R.id.registration);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }

            private void checkDataEntered() {
                if (isEmpty(Name)) {
                    Name.setError("first name is required!");
                }



            }
        });


    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}
