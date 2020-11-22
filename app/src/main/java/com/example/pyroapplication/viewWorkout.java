package com.example.pyroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewWorkout extends AppCompatActivity {

    Button backButon;
    ListView list;
public static final String TAG = "ListDataActivity";
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
        list = findViewById(R.id.list);
        backButon = findViewById(R.id.back);
        databaseHelper =  new DatabaseHelper(this);




        populateListView();



        backButon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewWorkout.this, workoutPage.class);
                startActivity(intent);
            }
        });





    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView");

        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
           listData.add(data.getString(1));
        }


        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);

        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    String name = parent.getItemAtPosition(i).toString();
                    Log.d(TAG, "OnItemClick: Clicked " + name );

                    Cursor data = databaseHelper.getItemID(name);
                    int item = -1;
                    while(data.moveToNext()) {
                        item = data.getInt(0);
                    }
                    if(item > -1) {
                        Log.d(TAG, "onItemClick: The ID is: " + item);
                        Intent workoutEditPage = new Intent(viewWorkout.this , workoutEdit.class);
                        workoutEditPage.putExtra("id",item);
                        workoutEditPage.putExtra("name", name);
                        startActivity(workoutEditPage);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No ID with that name", Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }

}