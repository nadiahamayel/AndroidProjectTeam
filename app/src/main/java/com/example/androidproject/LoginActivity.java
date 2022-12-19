package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button register;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setupUI();
            setupListeners();
        }

    private void setupUI() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        register = findViewById(R.id.registration);
        login = findViewById(R.id.login);
    }
    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsername();
//                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisteratiomActivity.class);
                startActivity(i);
            }
        });
    }

    void checkUsername() {
        boolean isValid = true;
        if (isEmpty(username)) {
            username.setError("You must enter username to login!");
            isValid = false;
        }

        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }

        if (isValid) {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            if (usernameValue.equals("test@test.com") && passwordValue.equals("password1234")) {
                //everything checked we open new activity
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                //we close this activity
                this.finish();
            }
            else  if (usernameValue.equals("admin@admin.com") && passwordValue.equals("admin")) {
                //everything checked we open new activity
                Intent i = new Intent(LoginActivity.this, Home_Admin_Activity.class);
                startActivity(i);
                //we close this activity
                this.finish();
            }
            else {
                Toast t ;
               t = Toast.makeText(this, "Wrong UserName or password!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}

