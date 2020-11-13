package com.example.pyroapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class viewWorkout extends AppCompatActivity {
    ListView list;
public static final String TAG = "ListDataActivity";
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
         list = findViewById(R.id.list);
        databaseHelper =  new DatabaseHelper(this);

        populateListView();




    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView");

        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
           listData.add(data.getString(1));
        }


        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);

        list.setAdapter(adapter);

    }

}