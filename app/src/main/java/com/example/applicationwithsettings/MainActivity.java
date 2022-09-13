package com.example.applicationwithsettings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // without toolbar we can't inflate the option menu
        Toolbar toolbar = findViewById(R.id.toolbar);  // find the toolbar
        toolbar.setTitle("Trying Menu");
        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_settings) {
                    Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        // initialise the Shared Preference by getting the Shared Preference for this activity
        SharedPreferences sharedPreferences = PreferenceManager
                                                    .getDefaultSharedPreferences(this);

        // get the switch value from the SharedPreference with it's key
        Boolean setting_switch = sharedPreferences
                                        .getBoolean(SettingsActivity.PREF_SETTING_KEY,false);  // second argument is default
        // show the current setting
        Toast.makeText(this,setting_switch.toString(),Toast.LENGTH_SHORT).show();
    }
}