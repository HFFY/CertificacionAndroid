package com.example.kenkogym.excercises.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.kenkogym.R;
import com.example.kenkogym.excercises.viewModel.ExcercisesViewModel;

public class ExcercisesActivity extends AppCompatActivity {
    private ExcercisesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);
        viewModel= new ViewModelProvider(this).get(ExcercisesViewModel.class);
    }
    public void getExercises(Long id){
        viewModel.getExercises(id);
    }
}
