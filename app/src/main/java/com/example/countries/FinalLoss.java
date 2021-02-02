package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countries.ui.main.FinalFragmentLoss;

public class FinalLoss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_loss_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FinalFragmentLoss.newInstance())
                    .commitNow();
        }
    }
}