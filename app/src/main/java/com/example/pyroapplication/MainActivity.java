package com.example.pyroapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {
    Button workoutButton;
    private  int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Connected To FireBase DataBase",Toast.LENGTH_SHORT).show();
        FloatingActionButton fab = findViewById(R.id.fab);

        workoutButton = findViewById(R.id.login);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count <= 10 )
                Snackbar.make(view, "Hello There! ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                else
                    Snackbar.make(view, "Look who is counting faster then Nevada!!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                count += 1;







            }


        });

            workoutButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this , workoutActivity.class);
                    startActivity(intent);
                }
            }) ;

    }
    }