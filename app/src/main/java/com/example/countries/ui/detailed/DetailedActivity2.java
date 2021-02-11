package com.example.countries.ui.detailed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countries.R;
import com.example.countries.ui.detailed.DetailedCountry2Fragment;

public class DetailedActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_activity2);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DetailedCountry2Fragment.newInstance())
                    .commitNow();
        }
    }
}