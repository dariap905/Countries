package com.example.countries;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private ArrayList<Country> items;
    private CountryAdapter adapter;
    private CountriesViewModel viewModel;

    public static ArrayList<Country> selectedItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lv_countries, container, false);

        ListView lvCartas = view.findViewById(R.id.lvCountries);

        items = new ArrayList<>();
        selectedItems = new ArrayList<>(2);
        adapter = new CountryAdapter(
                getContext(),
                R.layout.lv_countries_row,
                items
        );

        lvCartas.setAdapter(adapter);

        lvCartas.setOnItemClickListener((adapter, fragment, i, l) -> {
            Country country = (Country) adapter.getItemAtPosition(i);
            selectedItems.add(country);

            Intent intent = new Intent(getContext(), DetailedActivity.class);
            intent.putExtra("country", country);
            startActivity(intent);
        });

        viewModel = ViewModelProviders.of(this).get(CountriesViewModel.class);
        viewModel.getCountries().observe(getViewLifecycleOwner(), countries -> {
            adapter.clear();
            adapter.addAll(countries);
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
        /*RefreshDataTask task = new RefreshDataTask();
        task.execute();*/
        viewModel.reload();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        refresh();
    }
}