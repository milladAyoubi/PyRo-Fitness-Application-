package com.example.pyroapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
     Button loginButton;
     Button registerButton;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginButton = findViewById(R.id.login);
        registerButton = findViewById(R.id.register);


        /*    workoutButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                   Intent intent = new Intent(MainActivity.this, workoutPage.class);
                    startActivity(intent);
                }
            }) ;
*/

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });



        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        Toast.makeText(MainActivity.this , "Firebase connection success", Toast.LENGTH_LONG).show();




    }
    }