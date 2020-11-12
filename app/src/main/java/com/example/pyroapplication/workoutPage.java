package com.example.pyroapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class workoutPage extends AppCompatActivity {
    CalendarView calanderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        calanderView = (CalendarView) findViewById(R.id.workoutDate);

        calanderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = (dayOfMonth) + "/" + month + "/" + year;
                Toast.makeText(workoutPage.this, date, Toast.LENGTH_SHORT).show();
            }
        });


    }

}