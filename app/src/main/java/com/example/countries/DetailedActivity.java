package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countries.ui.main.DetailedCountryFragment;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_country_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DetailedCountryFragment.newInstance())
                    .commitNow();
        }
    }
}