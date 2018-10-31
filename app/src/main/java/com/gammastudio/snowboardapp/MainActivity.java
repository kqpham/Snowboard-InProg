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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Snowboard SB;
    private Boot boot;
    private Bindings bindings;
    private Goggle goggle;
    private Helmit helmit;

    private FloatingActionButton addNewSetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");
        mRecyclerView = (RecyclerView) findViewById(R.id.gear_list);

        //used to set list size
        mRecyclerView.setHasFixedSize(true);
        // linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        addNewSetButton = findViewById(R.id.add_new_set);
        addNewSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSetCreation();
            }
        });
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



    //Getting the values from the json and setting

    public void json(){
        String jsonStr;

        try {
            InputStream is = getAssets().open("items.json");
            int size =  is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();
            jsonStr = new String(buffer,"UTF-8");

            JSONObject jsonObj = new JSONObject(jsonStr);

            // Getting JSON Array node
            JSONArray snowboards = jsonObj.getJSONArray("snowboards");


            for(int i = 0; i < snowboards.length() ; i++){

                JSONObject s = snowboards.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                SB = new Snowboard(Integer.parseInt(id), name, brand, Float.parseFloat(price) ,Float.parseFloat(rating), image );

            }

            JSONArray Boot = jsonObj.getJSONArray("boots");

            for(int i = 0; i < Boot.length() ; i++){

                JSONObject s = Boot.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                boot = new Boot(Integer.parseInt(id), name, brand, Float.parseFloat(price) ,Float.parseFloat(rating), image );

            }

            JSONArray bind = jsonObj.getJSONArray("bindings");

            for(int i = 0; i < bind.length() ; i++){

                JSONObject s = bind.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                bindings = new Bindings(Integer.parseInt(id), name, brand, Float.parseFloat(price) ,Float.parseFloat(rating), image );

            }

            JSONArray GOGGLE = jsonObj.getJSONArray("goggles");

            for(int i = 0; i < GOGGLE.length() ; i++){

                JSONObject s = GOGGLE.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                goggle = new Goggle(Integer.parseInt(id), name, brand, Float.parseFloat(price) ,Float.parseFloat(rating), image );

            }

            JSONArray helmets = jsonObj.getJSONArray("helmets");

            for(int i = 0; i < helmets.length() ; i++){

                JSONObject s = helmets.getJSONObject(i);

                String id = s.getString("id");
                String name = s.getString("name");
                String brand = s.getString("brand");
                String price = s.getString("price");
                String rating = s.getString("rating");
                String image = s.getString("image");

                helmit = new Helmit(Integer.parseInt(id), name, brand, Float.parseFloat(price) ,Float.parseFloat(rating), image );

            }



        } catch (IOException e) {
            e.printStackTrace();
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}
