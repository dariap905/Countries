package com.example.countries.ui.detailed;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.countries.ui.bet.BetActivity;
import com.example.countries.ui.tools.Country;
import com.example.countries.R;


public class DetailedCountry2Fragment extends Fragment {

    private View view;
    private ImageView flagUrl;

    private TextView name;
    private TextView capital;
    private TextView population;
    private TextView nativeName;
    private TextView numericCode;

    DetailedViewModel mViewModel;

    public static DetailedCountry2Fragment newInstance() {
        return new DetailedCountry2Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detailed_info2, container, false);

        Intent i = getActivity().getIntent();

        if (i != null) {
            Country country = (Country) i.getSerializableExtra("country");

            if (country != null) {
                updateUi(country);
            }
        }

        return view;
    }

    private void updateUi(Country country) {
        Log.d("COUNTRY", country.toString());

        name =  view.findViewById(R.id.lvName);
        nativeName = view.findViewById(R.id.lvNativeName);
        capital =   view.findViewById(R.id.lvCapital);
        population =   view.findViewById(R.id.lvPopulation);
        numericCode =   view.findViewById(R.id.lvNumericCode);
        flagUrl = view.findViewById(R.id.lvFlag);

        //name.setText(getString(R.string.country_name, country.getName()));
        name.setText(country.getName());
        nativeName.setText(country.getNativeName());
        capital.setText("Capital: " + country.getCapital());
        population.setText("Population: " + country.getPopulation());
        numericCode.setText(country.getNumericCode());

        Glide.with(getContext()).load(country.getFlagUrl()).into(flagUrl);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_choose_first_country).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BetActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailedViewModel.class);
        // TODO: Use the ViewModel
    }

}