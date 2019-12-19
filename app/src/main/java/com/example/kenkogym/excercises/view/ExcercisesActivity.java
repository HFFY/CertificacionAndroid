package com.example.kenkogym.excercises.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kenkogym.R;
import com.example.kenkogym.excercises.viewModel.ExcercisesViewModel;
import com.example.kenkogym.utils.models.objects.Exercise;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.example.kenkogym.userMain.view.UserMainActivity.idUserSelected;

public class ExcercisesActivity extends AppCompatActivity {
    private ExcercisesViewModel viewModel;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    TextView textViewNoExcs;
    ExcercisesAdapter adapter;
    Activity activity = this;
    List<Exercise> exercisesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);

        recyclerView = findViewById(R.id.recycler_exc);
        textViewNoExcs = findViewById(R.id.text_no_excs);
        viewModel = new ViewModelProvider(this).get(ExcercisesViewModel.class);

        getExercisesListUser();

    }

    public void getExercises(final List<String> ids) {
        viewModel.getAllExercises().observe(this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                selectedExcs(exercises, ids);
            }
        });
    }

    public void getExercisesListUser() {
        viewModel.getExercises(idUserSelected).observeForever(new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strinasignedMusselss) {
                getExercises(strinasignedMusselss);
            }
        });
    }

    public void selectedExcs(List<Exercise> exercises, List<String> ids) {
        if (ids == null) {
            textViewNoExcs.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else if (ids.size() == 0) {
            textViewNoExcs.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            textViewNoExcs.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            for(int i = 0; i < ids.size(); i++){
                for(int j = 0; j < exercises.size() ; j++){
                    if(ids.get(i).equals(exercises.get(j).getId())){
                        Exercise exercise = exercises.get(j);
                        exercisesList.add(exercise);
                    }
                }
            }
            linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter = new ExcercisesAdapter(activity, exercisesList);
            recyclerView.setAdapter(adapter);
        }
    }

}
