package com.example.pyroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    Button register2Button;
    private EditText editTextName, editTextEmail, editTextPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        register2Button = findViewById(R.id.register2);

        editTextName =  findViewById(R.id.editTextTextPersonName3);
        editTextEmail =  findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);

        register2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             registerUser();
            }

            private void registerUser() {
                 final String name = editTextName.getText().toString().trim();
                 final String email = editTextEmail.getText().toString().trim();
                 final String password = editTextPassword.getText().toString().trim();


                if(name.isEmpty()){
                    editTextName.setError("Name is required!");
                    editTextName.requestFocus();
                    return;
                }

                if(email.isEmpty()){
                    editTextEmail.setError("Email is required!");
                    editTextEmail.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editTextEmail.setError("Please provide valid email!");
                    editTextEmail.requestFocus();
                    return;
                }

                if(password.isEmpty()){
                    editTextPassword.setError("Password is required!");
                    editTextPassword.requestFocus();
                    return;
                }

                if(password.length() < 6){
                    editTextPassword.setError("Min password length should be 6 characters!");
                    editTextPassword.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(name, email, password);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this,"User has been registered successfully!", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                    }else{
                                        Toast.makeText(RegisterActivity.this,"Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });



                        }else{
                            Toast.makeText(RegisterActivity.this,"Failed to register! Try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });





        }

}