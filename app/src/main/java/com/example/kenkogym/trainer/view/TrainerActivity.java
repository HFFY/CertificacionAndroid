package com.example.kenkogym.trainer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kenkogym.R;

import java.util.ArrayList;
import java.util.List;

public class TrainerActivity extends AppCompatActivity {

    Button buttonSave;
    RecyclerView recyclerViewExc;
    LinearLayoutManager linearLayoutManager;
    TrainerExcerciseSelectionAdapter adapter;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

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
