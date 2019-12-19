package com.example.kenkogym.excercises.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.kenkogym.R;
import com.example.kenkogym.excercises.viewModel.ExcercisesViewModel;

import java.util.ArrayList;
import java.util.List;

public class ExcercisesActivity extends AppCompatActivity {
    private ExcercisesViewModel viewModel;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ExcercisesAdapter adapter;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);

        recyclerView = findViewById(R.id.recycler_exc);

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
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ExcercisesAdapter(activity, strings);
        recyclerView.setAdapter(adapter);
        viewModel= new ViewModelProvider(this).get(ExcercisesViewModel.class);
    }
    public void getExercises(Long id){
        viewModel.getExercises(id);
    }
}
