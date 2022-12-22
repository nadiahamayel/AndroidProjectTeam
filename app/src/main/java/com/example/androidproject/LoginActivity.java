package com.example.androidproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
    private boolean save = false;
    private SharedPreferences sharedPreferences; //for read
    private SharedPreferences.Editor editor;

    public static final String USERNAME = "Oraib";
    public static final String PASSWORD = "password";
    private  boolean flag = true ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setupUI();
            setupListeners();
            setUpSharedPerf ();
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
                save = true;
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

    @Override
    protected void onStop() {
        super.onStop();
        if (!save) {
            String use = username.getText().toString().trim();
            String pass = password.getText().toString();


            editor.putString(USERNAME, use);
            editor.putString(PASSWORD, pass);
            editor.putBoolean("FLAG" , flag); // if have data or not
            editor.commit();
        }
    }
    private void setUpSharedPerf (){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor=sharedPreferences.edit();
    }

    //this method for onCreate and check if
    private void checkData() {
        boolean f = sharedPreferences.getBoolean("FLAG" , false);
        //if exits return it
        if (f){
            String name = sharedPreferences.getString(USERNAME, "");
            String pass = sharedPreferences.getString(PASSWORD , "");
            username.setText(name);
            password.setText(pass);
        }
    }
}

