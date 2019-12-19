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

public class TrainerActivity extends AppCompatActivity {
    private TrainerViewModel viewModel;

    Button buttonSave;
    RecyclerView recyclerViewExc;
    LinearLayoutManager linearLayoutManager;
    TrainerExcerciseSelectionAdapter adapter;
    Activity activity = this;


    List<Exercise> exercisesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);
        viewModel= new ViewModelProvider(this).get(TrainerViewModel.class);


        //ROOM exercises
        viewModel = new ViewModelProvider(this).get(TrainerViewModel.class);

        viewModel.getAllExercises().observe(this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                Log.e("Exercises", new Gson().toJson(exercises));
            }
        });
    }

    public void getExercises(){
        viewModel.getAllExercises().observe(this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                exercisesList=exercises;
                Log.e("Exercises", new Gson().toJson(exercises));
            }
        });
    }


    public void setExercise(ArrayList<String> exercises,Long id){
        viewModel.setExercises(exercises,id);

        buttonSave = findViewById(R.id.button_trainer_save);
        recyclerViewExc = findViewById(R.id.recycler_excercises);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewExc.setLayoutManager(linearLayoutManager);
        adapter = new TrainerExcerciseSelectionAdapter(activity,strings);
        recyclerViewExc.setAdapter(adapter);


    }
}
