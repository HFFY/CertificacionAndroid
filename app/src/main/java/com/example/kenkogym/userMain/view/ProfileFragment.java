package com.example.kenkogym.userMain.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kenkogym.R;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    static TextView textViewWeight, textViewHeight, textViewAge, textViewHours;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_fragment, container, false);
        textViewWeight = view.findViewById(R.id.text_weight);
        textViewHeight = view.findViewById(R.id.text_tall);
        textViewAge = view.findViewById(R.id.text_age);
        textViewHours = view.findViewById(R.id.text_hours);

//        textViewWeight.setText("100 Kg");
//        textViewHeight.setText("1.80 cm");
//        textViewAge.setText("22 años");
//        textViewHours.setText("180 Horas");

        return view;
    }
}
