package com.example.pyroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {
    Button enterbutton;
    Button viewbutton;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        enterbutton = findViewById(R.id.EnterWO);
        viewbutton = findViewById(R.id.ViewWO);
        logout = findViewById(R.id.Logout);


        enterbutton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                   Intent intent = new Intent(MainMenu.this, workoutPage.class);
                    startActivity(intent);
                }
            }) ;

        viewbutton.setOnClickListener(new View.OnClickListener(){
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(MainMenu.this, viewWorkout.class);
                     startActivity(intent);
            }
        }) ;

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainMenu.this, "Logged Out!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainMenu.this, MainActivity.class));
            }
        }) ;



    }
}