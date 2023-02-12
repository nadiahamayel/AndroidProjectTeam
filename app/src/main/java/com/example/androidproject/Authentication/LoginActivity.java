package com.example.androidproject.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.AdminSide.AdminHomeActivity;
import com.example.androidproject.R;
import com.example.androidproject.UserSide.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private boolean save = false;
    private  boolean flag = true ;
    //object from firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    //object from database reference class , must add child user or recipe
    DatabaseReference reference = database.getReference().child("user");

    //this reference for get data from database and I don't need to child
    DatabaseReference referenceToGet = database.getReference();



    EditText email , password ;
    Button login , register , forgetPasswordBtn , phoneNumber;
    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.registration);
        forgetPasswordBtn = findViewById(R.id.forgetPassword);
        phoneNumber = findViewById(R.id.phoneNumber);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = email.getText().toString();
                String pass = password.getText().toString();
                LoginFirebase(username, pass);
                if (username.equals("admin@gmail.com") && pass.equals("admin123")) {
                    //everything checked we open new activity
                    Intent i = new Intent(LoginActivity.this, AdminHomeActivity.class);
                    startActivity(i);
                    //we close this activity
                    finish();
                }
                else {
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }


            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, Register.class);
                startActivity(i);
            }
        });

        forgetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(i);
            }
        });

        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(LoginActivity.this, PhoneNumber.class);
                startActivity(i);
            }
        });

//        name = findViewById(R.id.username);
//        Login_btn = findViewById(R.id.btn);
//        textView = findViewById(R.id.textView);
//
//      //  call or get data from database
//        referenceToGet.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//              String nameFromDB = (String) snapshot.child("user").child("name").getValue();
//              textView.setText(nameFromDB);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//
//        //send data to database
//        Login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String userName = name.getText().toString();
//
//                reference.child("phone").setValue(userName);
//
//            }
//        });
//
//

    }

    public void  LoginFirebase (String email , String password){

        Toast.makeText(LoginActivity.this,"Hello Log in "+ email + "   " + password , Toast.LENGTH_SHORT).show();
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task  ) {

                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this,"YES", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(LoginActivity.this,"Try again ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    @Override
    ///orientation
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("username", email.getText().toString());
        outState.putString("password", password.getText().toString());
        outState.putBoolean("save", save);
        outState.putBoolean("flag", flag);
    }

    @Override
    ///orientation
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        email.setText(savedInstanceState.getString("username"));
        password.setText(savedInstanceState.getString("password"));
        save = savedInstanceState.getBoolean("save");
        flag = savedInstanceState.getBoolean("flag");
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        FirebaseUser user = auth.getCurrentUser();
//        if ( user != null){
//            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//            startActivity(i);
//            finish();
//
//        }
//    }
}

