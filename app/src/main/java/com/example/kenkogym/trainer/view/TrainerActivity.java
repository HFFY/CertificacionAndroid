package com.example.kenkogym.trainer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.kenkogym.R;
import com.example.kenkogym.trainer.viewModel.TrainerViewModel;
import com.example.kenkogym.utils.models.objects.Exercise;
import com.google.gson.Gson;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

import static com.example.kenkogym.userMain.view.UserMainActivity.idUserSelected;

public class TrainerActivity extends AppCompatActivity {
    private TrainerViewModel viewModel;

    Button buttonSave;
    RecyclerView recyclerViewExc;
    LinearLayoutManager linearLayoutManager;
    TrainerExcerciseSelectionAdapter adapter;
    Activity activity = this;
    List<Exercise> exercisesList = new ArrayList<>();
    List<String> selectedExc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);
        viewModel = new ViewModelProvider(this).get(TrainerViewModel.class);
        buttonSave = findViewById(R.id.button_trainer_save);
        recyclerViewExc = findViewById(R.id.recycler_excercises);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setExercises(selectedExc,idUserSelected);
            }
        });

        getExercises();
    }

    public void getExercises() {
        viewModel.getAllExercises().observe(this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                exercisesList = exercises;
                Log.e("Exercises", new Gson().toJson(exercises));
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerViewExc.setLayoutManager(linearLayoutManager);
                adapter = new TrainerExcerciseSelectionAdapter(activity, exercisesList);
                recyclerViewExc.setAdapter(adapter);
            }
        });
    }

    public void setSelection(String id, Boolean selected) {
        if (selected) {
            selectedExc.add(id);
        } else {
            selectedExc.remove(id);
        }
    }
}
