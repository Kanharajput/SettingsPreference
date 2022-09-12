package com.example.applicationwithsettings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // add the setting fragment to the activity
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content,new SettingsFragment())    //android have a pre-defined layout and content is the container there on which are replacing our fragment
                .commit();
    }
}