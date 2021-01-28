package com.example.countries;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BetAdapter extends ArrayAdapter<Country> {

    ArrayList<Country> countryList;

    public BetAdapter(Context context, int resource, ArrayList<Country> objects) {
        super(context, resource, objects);
        countryList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Country country = getItem(position);
        Log.w("XXXX", country.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.bet_fragment, parent, false);
        }

        for (int i = 0; i < countryList.size(); i++) {
            if(i == 0){
                TextView tvName = convertView.findViewById(R.id.tvName);
                TextView tvNativeName = convertView.findViewById(R.id.tvNativeName);

                tvName.setText(country.getName());
                tvNativeName.setText(country.getNativeName());
            }

            if(i != 0){
                TextView tvName2 = convertView.findViewById(R.id.tvName);
                TextView tvNativeName2 = convertView.findViewById(R.id.tvNativeName);

                tvName2.setText(country.getName());
                tvNativeName2.setText(country.getNativeName());
            }
        }

        return convertView;
    }

}

