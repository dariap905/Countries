package com.example.countries.ui.bet;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.countries.ui.tools.Country;
import com.example.countries.R;
import com.example.countries.ui.last.FinalLoss;
import com.example.countries.ui.last.FinalWin;

import java.util.List;
import java.util.Random;

public class BetAdapter extends ArrayAdapter<Country> {

    //local context
    private Context context;
    Random r = new Random();
    int chance;

    public BetAdapter(Context context, int resource, List<Country> objects) {
        super(context, resource, objects);
        //assigning BetFragment's context
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Country country = getItem(position);
        Log.w("XXXX", country.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.bet_fragment, parent, false);
            TextView lvName = convertView.findViewById(R.id.lvName);
            TextView lvNativeName = convertView.findViewById(R.id.lvNativeName);

            lvName.setText(country.getName());
            lvNativeName.setText(country.getNativeName());

        }


        //to set a button listener that can start a new Activity inside this adapter, I had to create a local context variable and then assign BetFragment's context to it

        Button btn = convertView.findViewById(R.id.bet1);
        btn.setOnClickListener(v -> {

            chance = r.nextInt(100);
            Intent intent;

            if(chance >= 50){
                intent = new Intent(getContext(), FinalWin.class);
            }
            else{
                intent = new Intent(getContext(), FinalLoss.class);
            }
            context.startActivity(intent);

        });

        return convertView;
    }
}

