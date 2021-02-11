package com.example.countries.ui.bet;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.countries.ui.tools.Country;
import com.example.countries.R;
import com.example.countries.ui.main.ThirdFragment;

import java.util.ArrayList;

public class BetFragment extends Fragment {

    private ArrayList<Country> selectedItems;
    private BetAdapter adapter;

    public static BetFragment newInstance() {
        return new BetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bet, container, false);

        ListView lvCountries = view.findViewById(R.id.listBet);

        selectedItems = ThirdFragment.selectedItems;

        adapter = new BetAdapter(
                getContext(),
                R.layout.bet_fragment,
                selectedItems
        );

        lvCountries.setAdapter(adapter);

        return view;
    }

}