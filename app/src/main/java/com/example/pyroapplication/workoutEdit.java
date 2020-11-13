package com.example.pyroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class workoutEdit extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    Button delete;

    EditText editItem;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_edit);


        delete = findViewById(R.id.editButton);
        editItem = findViewById(R.id.editItem);

        databaseHelper = new DatabaseHelper(this);

        Intent receivedIntent = getIntent();

        final int selectedID = receivedIntent.getIntExtra("id", -1);

        final String selectedName = receivedIntent.getStringExtra("name");


        editItem.setText(selectedName);

       /* save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editItem.getText().toString();

                if(value.equals("")) {

                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                }
            }
        }); */


       delete.setOnClickListener(new View.OnClickListener() {
           @Override


           public void onClick(View v) {
               Intent intent = new Intent(workoutEdit.this, viewWorkout.class);
            databaseHelper.deleteName(selectedID,selectedName);
            databaseHelper.getReadableDatabase();
            editItem.setText("");
               Toast.makeText(getApplicationContext(), "Removed Workout", Toast.LENGTH_SHORT).show();
               startActivity(intent);
           }
       });

    }
}