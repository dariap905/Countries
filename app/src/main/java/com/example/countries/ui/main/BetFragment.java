package com.example.countries.ui.main;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.countries.BetAdapter;
import com.example.countries.Country;
import com.example.countries.CountryAdapter;
import com.example.countries.R;

import java.util.ArrayList;

public class BetFragment extends Fragment {

    private BetViewModel mViewModel;

    private ArrayList<Country> selectedItems;
    private BetAdapter adapter;

    public static BetFragment newInstance() {
        return new BetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bet_fragment, container, false);

        //ListView lvCartas = view.findViewById(R.id.lvCountries);

        selectedItems = ThirdFragment.selectedItems;

        for (int i = 0; i < selectedItems.size(); i++) {
            if(i == 0){
                TextView tvName = view.findViewById(R.id.tvName);
                TextView tvNativeName = view.findViewById(R.id.tvNativeName);

                tvName.setText(country.getName());
                tvNativeName.setText(country.getNativeName());
            }

            if(i != 0){
                TextView tvName2 = view.findViewById(R.id.tvName2);
                TextView tvNativeName2 = view.findViewById(R.id.tvNativeName2);

                tvName2.setText(country.getName());
                tvNativeName2.setText(country.getNativeName());
            }
        }

/*        adapter = new BetAdapter(
                getContext(),
                R.layout.bet_fragment,
                selectedItems
        );

        lvCartas.setAdapter(adapter);*/

        return view;
    }

}