package com.example.pyroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class workoutPage extends AppCompatActivity {
    CalendarView calenderView;


    int calories;
    int duration;
    String type;
    Button workoutEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        calenderView =  findViewById(R.id.workoutDate);
        workoutEnter = findViewById(R.id.enterButton);

        calenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (dayOfMonth) + "/" + month + "/" + year;
                Toast.makeText(workoutPage.this, date, Toast.LENGTH_SHORT).show();
            }
        });



    }

}