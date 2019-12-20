package com.example.kenkogym.mussles.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.kenkogym.R;
import com.example.kenkogym.mussles.viewModel.MusselsViewModel;
import com.example.kenkogym.utils.models.objects.Exercise;
import com.google.gson.Gson;

import java.util.List;

public class MusselsActivity extends AppCompatActivity {

    private Context context;
    private MusselsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mussels);

        context = this;
        viewModel = new ViewModelProvider(this).get(MusselsViewModel.class);

        viewModel.getAllExercises().observe(this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                Log.e("Exercises", new Gson().toJson(exercises));
            }
        });

    }
}
