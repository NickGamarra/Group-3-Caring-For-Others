package edu.fau.ngamarra2014.sync_care;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.json.JSONException;
import org.json.JSONObject;

public class PatientProfileActivity extends AppCompatActivity {

    JSONObject info;
    EditText firstname, lastname, DOB, primarynum, emergancynum, address, city, zipcode;
    ImageButton edit, back;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_profile_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        DOB = (EditText) findViewById(R.id.dob);
        primarynum = (EditText) findViewById(R.id.phonenum);
        emergancynum = (EditText) findViewById(R.id.emernum);
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);
        zipcode = (EditText) findViewById(R.id.zipcode);
        edit = (ImageButton) findViewById(R.id.editButton);
        save = (Button) findViewById(R.id.save);
        back = (ImageButton) findViewById(R.id.previousButton);

        toggleTextFields(false);

        try{
            info = new JSONObject(getIntent().getStringExtra("patient"));
            firstname.setText(info.getString("first"));
            lastname.setText(info.getString("last"));
            DOB.setText(info.getString("birthdate"));
            primarynum.setText(info.getString("phone"));
            emergancynum.setText(info.getString("emergency"));
        }catch (JSONException e){

        }

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleTextFields(true);
                save.setVisibility(View.VISIBLE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    info.put("first", firstname.getText().toString());
                    info.put("last", lastname.getText().toString());
                    info.put("birthdate", DOB.getText().toString());
                    info.put("phone", primarynum.getText().toString());
                    info.put("emergency", emergancynum.getText().toString());

                    save.setVisibility(View.INVISIBLE);
                }catch (JSONException e){

                }
            }
        });
    }

    public void toggleTextFields(Boolean set){
        firstname.setFocusable(set);
        firstname.setFocusableInTouchMode(set);
        firstname.setClickable(set);
        lastname.setFocusable(set);
        lastname.setFocusableInTouchMode(set);
        lastname.setClickable(set);
        DOB.setFocusable(set);
        DOB.setFocusableInTouchMode(set);
        DOB.setClickable(set);
        primarynum.setFocusable(set);
        primarynum.setFocusableInTouchMode(set);
        primarynum.setClickable(set);
        emergancynum.setFocusable(set);
        emergancynum.setFocusableInTouchMode(set);
        emergancynum.setClickable(set);
        address.setFocusable(set);
        address.setFocusableInTouchMode(set);
        address.setClickable(set);
        city.setFocusable(set);
        city.setFocusableInTouchMode(set);
        city.setClickable(set);
        zipcode.setFocusable(set);
        zipcode.setFocusableInTouchMode(set);
        zipcode.setClickable(set);
    }
}