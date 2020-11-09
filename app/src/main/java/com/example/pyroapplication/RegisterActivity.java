package com.example.pyroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    Button register2Button;
    EditText email;
    EditText password;
    EditText name;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email =findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        name = findViewById(R.id.editTextTextPersonName3);
        register2Button = findViewById(R.id.register2);

        auth = FirebaseAuth.getInstance();

        register2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String txt_email = email.getText().toString();
            String txt_password = password.getText().toString();
            String txt_name = name.getText().toString();

            if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_name)) {
                Toast.makeText(RegisterActivity.this, "Empty Credential", Toast.LENGTH_SHORT).show();
            } else if (txt_password.length()<6) {
                Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
            } else {
                registerUser(txt_email, txt_password);
            }


            }
        });
    }

        private void registerUser(String email, String password) {

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Register user successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

}