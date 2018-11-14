package com.gammastudio.snowboardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DatabaseSupport.AppDatabase;


public class gearSelect extends AppCompatActivity {

    public String[][] snowboard_arr = new String[50][10];
    public String[][] boot_arr = new String[50][10];
    public String[][] bindings_arr = new String[50][10];
    public String[][] goggle_arr = new String[50][10];
    public String[][] helmet_arr = new String[50][10];
    private ArrayList<String> boards = new ArrayList<>();
    private ArrayList<String> boardPrices = new ArrayList<>();
    public ArrayList<String> boardImages = new ArrayList<>();
    private static final String TAG = "boogieman";
    public String[] snowboardname = new String[20];
    public String[] snowboardprice= new String[20];
    public String[] snowboardimage = new String[20];
    private ArrayList<String> bindings = new ArrayList<>();
    private ArrayList<String> bindingsPrices = new ArrayList<>();
    public ArrayList<String> bindingsImages = new ArrayList<>();
    public String[] bootname = new String[20];
    public String[] bootprice= new String[20];
    public String[] bootimage = new String[20];
    private ArrayList<String> boots = new ArrayList<>();
    private ArrayList<String> bootsPrices = new ArrayList<>();
    public ArrayList<String> bootsImages = new ArrayList<>();
    public String[] bindingname = new String[20];
    public String[] bindingprice= new String[20];
    public String[] bindingimage = new String[20];
    private ArrayList<String> goggles = new ArrayList<>();
    private ArrayList<String> gogglesPrices = new ArrayList<>();
    public ArrayList<String> gogglesImages = new ArrayList<>();
    public String[] gogglename = new String[20];
    public String[] goggleprice= new String[20];
    public String[] goggleimage = new String[20];
    private ArrayList<String> helmets = new ArrayList<>();
    private ArrayList<String> helmetsPrices = new ArrayList<>();
    public ArrayList<String> helmetsImages = new ArrayList<>();
    public String[] helmetname = new String[20];
    public String[] helmetprice= new String[20];
    public String[] helmetimage = new String[20];
    public Float setbudget;






    private AppDatabase db;
    public void clickBoard(View view) {
        LinearLayout snowboardlayer = (LinearLayout) findViewById(R.id.boardSelectLayer);
        snowboardlayer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


    }

    public void clickBinding(View view){
        LinearLayout bindinglayer = (LinearLayout) findViewById(R.id.bindingSelectLayer);
        bindinglayer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


    }
    public void clickBoot(View view){
        LinearLayout snowboardlayer = (LinearLayout) findViewById(R.id.boardSelectLayer);
        LinearLayout bootlayer = (LinearLayout) findViewById(R.id.bootSelectLayer);
        LinearLayout bindinglayer = (LinearLayout) findViewById(R.id.bindingSelectLayer);
        LinearLayout helmetlayer = (LinearLayout) findViewById(R.id.helmetSelectLayer);
        bootlayer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));



    }
    public void clickHelmet(View view){
        LinearLayout snowboardlayer = (LinearLayout) findViewById(R.id.boardSelectLayer);
        LinearLayout helmetlayer = (LinearLayout) findViewById(R.id.helmetSelectLayer);

        helmetlayer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


    }
    public void clickGoggle(View view){
        LinearLayout snowboardlayer = (LinearLayout) findViewById(R.id.boardSelectLayer);
        LinearLayout gogglelayer = (LinearLayout) findViewById(R.id.goggleSelectLayer);
        gogglelayer.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


    }



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

                snowboard_arr[i][0] = id;
                snowboard_arr[i][1] = name;
                snowboard_arr[i][2] = brand;
                snowboard_arr[i][3] = price;
                snowboard_arr[i][4] = rating;
                snowboard_arr[i][5] = image;

                snowboardname[i] = snowboard_arr[i][1];
                snowboardprice[i] = snowboard_arr[i][3];
                snowboardimage[i] = snowboard_arr[i][5];
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



                boot_arr[i][0] = id;
                boot_arr[i][1] = name;
                boot_arr[i][2] = brand;
                boot_arr[i][3] = price;
                boot_arr[i][4] = rating;
                boot_arr[i][5] = image;

                bootname[i] = boot_arr[i][1];
                bootprice[i] = boot_arr[i][3];
                bootimage[i] = boot_arr[i][5];

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



                bindings_arr[i][0] = id;
                bindings_arr[i][1] = name;
                bindings_arr[i][2] = brand;
                bindings_arr[i][3] = price;
                bindings_arr[i][4] = rating;
                bindings_arr[i][5] = image;

                bindingname[i] = bindings_arr[i][1];
                bindingprice[i] = bindings_arr[i][3];
                bindingimage[i] = bindings_arr[i][5];
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



                goggle_arr[i][0] = id;
                goggle_arr[i][1] = name;
                goggle_arr[i][2] = brand;
                goggle_arr[i][3] = price;
                goggle_arr[i][4] = rating;
                goggle_arr[i][5] = image;

                gogglename[i] = goggle_arr[i][1];
                goggleprice[i] = goggle_arr[i][3];
                goggleimage[i] = goggle_arr[i][5];

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



                helmet_arr[i][0] = id;
                helmet_arr[i][1] = name;
                helmet_arr[i][2] = brand;
                helmet_arr[i][3] = price;
                helmet_arr[i][4] = rating;
                helmet_arr[i][5] = image;

                helmetname[i] = helmet_arr[i][1];
                helmetprice[i] = helmet_arr[i][3];
                helmetimage[i] = helmet_arr[i][5];

            }

        } catch (IOException e) {
            e.printStackTrace();
        }catch(JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gear_select);

        json();
        Bundle extras = getIntent().getExtras();
        //snowboard
        ArrayList<String> sbNameList = new ArrayList<String>(Arrays.asList(snowboardname));
        ArrayList<String> sbPriceList = new ArrayList<String>(Arrays.asList(snowboardprice));
        ArrayList<String> sbImageList = new ArrayList<String>(Arrays.asList(snowboardimage));
        //Binding
        ArrayList<String> bindingNameList = new ArrayList<String>(Arrays.asList(bindingname));
        ArrayList<String> bindingPriceList = new ArrayList<String>(Arrays.asList(bindingprice));
        ArrayList<String> bindingImageList = new ArrayList<String>(Arrays.asList(bindingimage));
        //Boots
        ArrayList<String> bootNameList = new ArrayList<String>(Arrays.asList(bootname));
        ArrayList<String> bootPriceList = new ArrayList<String>(Arrays.asList(bootprice));
        ArrayList<String> bootImageList = new ArrayList<String>(Arrays.asList(bootimage));
        //Goggles
        ArrayList<String> goggleNameList = new ArrayList<String>(Arrays.asList(gogglename));
        ArrayList<String> gogglePriceList = new ArrayList<String>(Arrays.asList(goggleprice));
        ArrayList<String> goggleImageList = new ArrayList<String>(Arrays.asList(goggleimage));
        //Helmets
        ArrayList<String> helmetNameList = new ArrayList<String>(Arrays.asList(helmetname));
        ArrayList<String> helmetPriceList = new ArrayList<String>(Arrays.asList(helmetprice));
        ArrayList<String> helmetImageList = new ArrayList<String>(Arrays.asList(helmetimage));

        //set the values
        //snowboards
        boards = sbNameList;
        boardPrices = sbPriceList;
        boardImages = sbImageList;
        //bindings
        bindings = bindingNameList;
        bindingsPrices = bindingPriceList;
        bindingsImages = bindingImageList;
        //boots
        boots = bootNameList;
        bootsPrices = bootPriceList;
        bootsImages = bootImageList;
        //goggles
         goggles = goggleNameList;
         gogglesPrices = gogglePriceList;
         gogglesImages = goggleImageList;
        //helmets
         helmets = helmetNameList;
         helmetsPrices = helmetPriceList;
         helmetsImages = helmetImageList;

         TextView setBudgetTxt = (TextView) findViewById(R.id.idealBudget);

         setbudget = extras.getFloat("setBudget");

         setBudgetTxt.setText(setbudget.toString());

        initRecyclerView();

    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager5 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        RecyclerView snowboardRsView = findViewById(R.id.boardView);
        RecyclerView bindingRsView = findViewById(R.id.bindingView);
        RecyclerView bootRsView = findViewById(R.id.bootView);
        RecyclerView goggleRsView = findViewById(R.id.goggleView);
        RecyclerView helmetRsView = findViewById(R.id.helmetView);

        snowboardRsView.setLayoutManager(layoutManager);
        bindingRsView.setLayoutManager(layoutManager2);
        bootRsView.setLayoutManager(layoutManager3);
        goggleRsView.setLayoutManager(layoutManager4);
        helmetRsView.setLayoutManager(layoutManager5);

        CustomAdapter adapter = new CustomAdapter(this,boards, boardPrices, boardImages);
        CustomAdapter5 adapter5 = new CustomAdapter5(this,bindings,bindingsPrices,bindingsImages);
        CustomAdapter2 adapter2 = new CustomAdapter2(this,boots,bootsPrices,bootsImages);
        CustomAdapter3 adapter3 = new CustomAdapter3(this, goggles, gogglesPrices, gogglesImages);
        CustomAdapter4 adapter4 = new CustomAdapter4(this,helmets,helmetsPrices, helmetsImages);

        snowboardRsView.setAdapter(adapter);
        bindingRsView.setAdapter(adapter5);
        bootRsView.setAdapter(adapter2);
        goggleRsView.setAdapter(adapter3);
        helmetRsView.setAdapter(adapter4);

       // adapter.getItemCount();

    }




}
