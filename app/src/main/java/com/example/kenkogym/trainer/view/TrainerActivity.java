package com.example.kenkogym.trainer.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.kenkogym.R;
import com.example.kenkogym.trainer.viewModel.TrainerViewModel;

import java.util.ArrayList;

public class TrainerActivity extends AppCompatActivity {
    private TrainerViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);
        viewModel= new ViewModelProvider(this).get(TrainerViewModel.class);
    }

    public void setExercise(ArrayList<String> exercises,Long id){
        viewModel.setExercises(exercises,id);
    }
}
