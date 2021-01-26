package com.example.countries;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private ArrayList<Country> items;
    private CountryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lv_countries, container, false);

        ListView lvCartas = view.findViewById(R.id.lvCountries);

        items = new ArrayList<>();
        adapter = new CountryAdapter(
                getContext(),
                R.layout.lv_countries_row,
                items
        );

        lvCartas.setAdapter(adapter);

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

        view.findViewById(R.id.button_choose_first_country).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}