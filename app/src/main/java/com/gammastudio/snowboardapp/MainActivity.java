package com.gammastudio.snowboardapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import DatabaseSupport.AppDatabase;
import DatabaseSupport.DatabaseInitializer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public AppDatabase appDatabase;

    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FloatingActionButton addNewSetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.gear_list);
//        mAdapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
//        mRecyclerView.setAdapter(mAdapter);
        //used to set list size
        mRecyclerView.setHasFixedSize(true);
        // linear layout manager

        mRecyclerView.setLayoutManager(mLayoutManager);

        addNewSetButton = findViewById(R.id.add_new_set);
        addNewSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSetCreation();
            }
        });

        //Initializing the Database
        InitializeDb();

        //specify adapter
        //mAdapter = new MyAdapter(myDataset);
        //mRecyclerView.setAdapter(mAdapter);
        }
        private void initImageBitmaps(){
            Log.d(TAG, "initImageBitmaps: getting bitmaps");
        }

        public void openSetCreation(){
            Intent intent = new Intent(this, SetCreationActivity.class);
            Log.d(TAG, "openSetCreation: Opening set creation page.");
            startActivity(intent);
        }

        public void InitializeDb(){
            Log.d(TAG, "InitializeDb: Initialize database ... start");
            appDatabase = AppDatabase.getFileDatabase(this.getApplication());
            DatabaseInitializer.populateAsync(appDatabase);
            Log.d(TAG, "InitializeDb: Initialize database ... complete");

        }


//    private ArrayAdapter arrayAdapter;
//    alphaListView.setAdapter(arrayAdapter);
//        for(int j=0; j < numericArray.length; j++){
//        numericArray[j] = Integer.toString(7 *(j+1)) ;
//    }
//    arrayAdapter2 = new ArrayAdapter(this, R.layout.gridviewx, R.id.gridviewlists,numericArray);
//        numericGridView.setAdapter(arrayAdapter2);


//    for(int i=0; i < songsArray.length; i++){
//        songsArray[i] = Character.toString((char)(int)(65+i));
//    }
//    arrayAdapter = new ArrayAdapter(this, R.layout.txtview,R.id.txtviewlist, songsArray);
//
//    // By using setAdapter method, you plugged the ListView with adapter
//        alphaListView.setAdapter(arrayAdapter);
}
