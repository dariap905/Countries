package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countries.ui.main.BetFragment;

public class BetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bet_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BetFragment.newInstance())
                    .commitNow();
        }
    }
}