package com.example.countries.ui.last;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.countries.R;

public class FinalFragmentLoss extends Fragment {

    private FinalViewModelLoss mViewModel;

    public static FinalFragmentLoss newInstance() {
        return new FinalFragmentLoss();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.final_fragment_loss, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FinalViewModelLoss.class);
        // TODO: Use the ViewModel
    }

}