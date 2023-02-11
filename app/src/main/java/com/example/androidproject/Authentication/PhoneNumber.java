package com.example.androidproject.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidproject.R;
import com.example.androidproject.UserSide.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneNumber extends AppCompatActivity {

    EditText edPhoneNumber , code  ;
    Button sendSMS , login;
    String sentCode ;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        edPhoneNumber = findViewById(R.id.EdPhone);
        code = findViewById(R.id.EdCode);
        sendSMS = findViewById(R.id.sentSMSBtn);
        login = findViewById(R.id.loginUsingPhone);

        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(PhoneNumber.this,"we send code", Toast.LENGTH_SHORT).show();

                String userPhoneNumber = edPhoneNumber.getText().toString();
                PhoneAuthProvider.getInstance().verifyPhoneNumber(userPhoneNumber, 60, TimeUnit.SECONDS, PhoneNumber.this, mCallBack);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginWithPhoneCode ();

            }
        });

    }

    public void loginWithPhoneCode (){
        String enterUserCode = sendSMS.getText().toString();
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(sentCode, enterUserCode);
        loginWithPhoneAuthCredential(credential);
    }

    public void loginWithPhoneAuthCredential(PhoneAuthCredential credential){
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if ( task.isSuccessful()){

                    Intent i = new Intent(PhoneNumber.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(PhoneNumber.this,"Code is not correct !!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            sentCode = s ;
        }
    };
}