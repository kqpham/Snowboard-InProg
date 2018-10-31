package com.gammastudio.snowboardapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SetCreationActivity extends AppCompatActivity {

    private Button selectEquipment;
//    private Button backButton;

    private EditText setInfo_setName;
    private EditText setInfo_setBudget;
    private RadioGroup setInfo_userSex;
    private EditText setInfo_shoeSize;
    private EditText setInfo_shirtsize;
    private EditText setInfo_pantWidth;
    private EditText setInfo_pantLength;
    private EditText setInfo_gloveSize;
    private static final String TAG = "SetCreation";

    private SetInfo newSetInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_creation);

        setInfo_setName = findViewById(R.id.set_name);
        setInfo_setBudget = findViewById(R.id.set_budget);
        setInfo_userSex = findViewById(R.id.sexSelectionRadioGroup);
        setInfo_shoeSize= findViewById(R.id.shoe_size);
        setInfo_shirtsize = findViewById(R.id.shirt_size);
        setInfo_pantLength=findViewById(R.id.pant_size_length);
        setInfo_pantWidth=findViewById(R.id.pant_size_width);
        setInfo_gloveSize=findViewById(R.id.glove_size);

//        backButton = (Button) findViewById(R.id.backBtn);
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        selectEquipment = (Button) findViewById(R.id.select_equipment_btn);
        selectEquipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate())
                {
                    addData();
                }
                else {
                    Toast.makeText(SetCreationActivity.this, "Please ensure all fields are filled.", Toast.LENGTH_SHORT).show();
                }
                //Pass object 'newSetInfo' to activity here
                passToActivity();
            }
        });
    }

    private void passToActivity() {

    }

    private boolean validate(){
        Log.i(TAG, "validate: in validate");
        //
        Log.i(TAG, "validate: value"+ setInfo_setName.getText().toString());
        if (setInfo_setName.getText().toString().isEmpty() && setInfo_gloveSize.getText().toString().isEmpty() && setInfo_setBudget.getText().toString().isEmpty() && setInfo_shoeSize.getText().toString().isEmpty() && setInfo_shirtsize.getText().toString().isEmpty() && setInfo_pantWidth.getText().toString().isEmpty() && setInfo_pantWidth.getText().toString().isEmpty()){
            selectEquipment.setEnabled(false);
            Log.d(TAG, "validate: false");
            return false;
        }
        else
        {
            selectEquipment.setEnabled(true);
            Log.d(TAG, "validate: true");
            return true;
        }
    }

    private void addData()
    {
        newSetInfo.setSetName(setInfo_setName.getText().toString());
        newSetInfo.setSetBudget(Float.parseFloat(setInfo_setBudget.getText().toString()));
        newSetInfo.setUserSex(setInfo_userSex.getCheckedRadioButtonId());
        newSetInfo.setShoeSize(Float.parseFloat(setInfo_shoeSize.getText().toString()));
        newSetInfo.setShirtsize(setInfo_shirtsize.getText().toString());
        newSetInfo.setPantWidth(Float.parseFloat(setInfo_pantWidth.getText().toString()));
        newSetInfo.setPantLength(Float.parseFloat(setInfo_pantLength.getText().toString()));
        newSetInfo.setGloveSize(String.valueOf(setInfo_gloveSize.getText()));
    }
}
