package com.gammastudio.snowboardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetCreationActivity extends AppCompatActivity {

    private static final String TAG = "SetCreation";
    private Button selectEquipment;
//    private Button backButton;

    private EditText setInfo_setName;
    private EditText setInfo_setBudget;


    private SetInfo newSetInfo = new SetInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_creation);

        setInfo_setName = findViewById(R.id.set_name);
        setInfo_setBudget = findViewById(R.id.set_budget);


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
        Intent intent = new Intent(this, gearSelect.class);
        intent.putExtra("setBudget",Float.parseFloat(String.valueOf(setInfo_setBudget.getText())));
        startActivity(intent);
    }

    private boolean validate(){

        if (setInfo_setName.getText().toString().isEmpty() && setInfo_setBudget.getText().toString().isEmpty()){
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

    }
}
