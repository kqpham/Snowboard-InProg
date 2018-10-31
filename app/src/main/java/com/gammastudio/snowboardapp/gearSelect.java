package com.gammastudio.snowboardapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class gearSelect extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gear_select);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView recycleItem = (ListView) findViewById(R.id.selectList);
        ArrayAdapter L = new ArrayAdapter(this,R.layout.rowview,R.id.spin, );
        ArrayAdapter S = new ArrayAdapter((this,R.layout.layout_spinner,);
    }


}
