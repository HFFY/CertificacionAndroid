package com.example.kenkogym.excercises.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kenkogym.R;
import com.example.kenkogym.excercises.viewModel.ExcercisesViewModel;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.ArrayList;
import java.util.List;

public class ExcercisesActivity extends AppCompatActivity {
    private ExcercisesViewModel viewModel;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ExcercisesAdapter adapter;
    Activity activity = this;

    List<Exercise> exercisesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercises);

        recyclerView = findViewById(R.id.recycler_exc);
        viewModel= new ViewModelProvider(this).get(ExcercisesViewModel.class);

        List<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");

        getExercises();

        //Room methods
        /*
        viewModel = new ViewModelProvider(this).get(ExcercisesViewModel.class);
*/



    }
//    public LiveData<List<String>> getExercises(Long id){
//        return viewModel.getExercises(id);
//    }

    public void getExercises(){
        viewModel.getAllExercises().observe(this, new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                exercisesList=exercises;
                Log.e("Exercises", new Gson().toJson(exercises));
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                adapter = new ExcercisesAdapter(activity, exercisesList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
    public LiveData<List<String>> getExercises(Long id){
        final MutableLiveData<List<String>> result = new MutableLiveData<>();
        viewModel.getExercises(id).observeForever(new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                result.postValue(strings);
            }
        });
        return result;

    }


}
