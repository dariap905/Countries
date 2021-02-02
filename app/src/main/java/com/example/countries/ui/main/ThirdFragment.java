package com.example.countries.ui.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.countries.Country;
import com.example.countries.CountryAPI;
import com.example.countries.CountryAdapter;
import com.example.countries.DetailedActivity2;
import com.example.countries.R;
import com.example.countries.SecondFragment;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {

    private ArrayList<Country> items;
    public static ArrayList<Country> selectedItems;
    private CountryAdapter adapter;

    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lv_countries, container, false);

        ListView lvCartas = view.findViewById(R.id.lvCountries);

        items = new ArrayList<>();
        selectedItems = SecondFragment.selectedItems;
        adapter = new CountryAdapter(
                getContext(),
                R.layout.lv_countries_row,
                items
        );

        lvCartas.setAdapter(adapter);

        lvCartas.setOnItemClickListener((adapter, fragment, i, l) -> {
            Country country = (Country) adapter.getItemAtPosition(i);
            selectedItems.add(country);

            Intent intent = new Intent(getContext(), DetailedActivity2.class);
            intent.putExtra("country", country);
            startActivity(intent);
        });

        return view;
    }


    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Country>> {

        @Override
        protected ArrayList<Country> doInBackground(Void... voids) {
            CountryAPI api = new CountryAPI();
            ArrayList<Country> result = api.getCountries();
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Country> countries) {
            adapter.clear();
            for (Country country : countries) {
                adapter.add(country);
            }
        }
    }

    private void refresh() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refresh();
    }
}