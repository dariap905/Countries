package com.example.countries;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(Context context, int resource, List<Country> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Country country = getItem(position);
        Log.w("XXXX", country.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_countries_row, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvNativeName = convertView.findViewById(R.id.tvNativeName);
        TextView tvCapital = convertView.findViewById(R.id.tvCapital);
        //ImageView ivFlag = convertView.findViewById(R.id.ivFlag);

        tvName.setText(country.getName());
        tvNativeName.setText(country.getNativeName());
        tvCapital.setText(country.getCapital());

        //Glide.with(getContext()).load(country.getFlagUrl()).into(ivFlag);

        return convertView;
    }

}

