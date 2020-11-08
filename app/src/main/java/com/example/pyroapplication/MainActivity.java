package com.example.pyroapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
     Button workoutButton = findViewById(R.id.login);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        workoutButton.setOnClickListener(new View.OnClickListener(){

                @Override


                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, workoutPage.class);
                    startActivity(intent);
                }
            }) ;

    }
    }