package com.example.pyroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class workoutPage extends AppCompatActivity {
    CalendarView calenderView;
    Button workoutEnter;
    Button viewWorkout;
    Button back;




    EditText workoutType;
    EditText workoutCalories;
    EditText workoutDuration;


    TextView dateLog;

    public static String calenderEntry;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        calenderView =  findViewById(R.id.workoutDate);
        workoutEnter = findViewById(R.id.enterButton);
        workoutType = findViewById(R.id.workoutType);
         workoutCalories = findViewById(R.id.workoutCalories);
         workoutDuration = findViewById(R.id.workoutDuration);
        viewWorkout  = findViewById(R.id.workoutView);
        back = findViewById(R.id.backbtn);


        dateLog = findViewById(R.id.dateLog);




        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                calenderEntry =  (dayOfMonth) + "/" + month + "/" + year;


            }
        });

        databaseHelper = new DatabaseHelper(this);

        workoutEnter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String workoutTypeEntry = workoutType.getText().toString();
                String workoutCaloriesEntry = workoutCalories.getText().toString();
                String workoutDurationEntry = workoutDuration.getText().toString();





                if(workoutType.length() !=0 && workoutCaloriesEntry.length() !=0 && workoutDurationEntry.length() !=0 ) {
                    String item =   calenderEntry + " -- " + workoutCaloriesEntry + " Cal -- " + workoutTypeEntry + " --  " + workoutDurationEntry + " min";
                    AddData(item);

                    workoutType.setText("");
                    workoutCalories.setText("");
                    workoutDuration.setText("");

                    dateLog.setText("Last Workout Logged " + calenderEntry);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Put Something first!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewWorkout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(workoutPage.this, viewWorkout.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(workoutPage.this, MainMenu.class);
                startActivity(intent);
            }
        });

    }

    public void AddData(String newEntry) {
        boolean insertData = databaseHelper.addData(newEntry);

        if(insertData)
            Toast.makeText(getApplicationContext(), "Added Data!", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(getApplicationContext(), "Wrong Data!", Toast.LENGTH_SHORT).show();



    }



}