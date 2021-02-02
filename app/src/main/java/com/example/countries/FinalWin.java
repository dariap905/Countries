package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countries.ui.main.FinalFragmentWin;

public class FinalWin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FinalFragmentWin.newInstance())
                    .commitNow();
        }
    }
}