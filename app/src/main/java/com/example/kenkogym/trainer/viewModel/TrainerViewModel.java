package com.example.kenkogym.trainer.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.trainer.TrainerRepository;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.ArrayList;
import java.util.List;

public class TrainerViewModel extends AndroidViewModel {
    private TrainerRepository repository;

    public TrainerViewModel(@NonNull Application application){
        super(application);
        repository=TrainerRepository.getInstance(application);
    }
    public void setExercises(ArrayList<String> exercises, Long id){
            repository.setExercises(exercises,id);
    }

    //ROOM methods
    public void registerExercise(final Exercise exercise) {
        final MutableLiveData<Exercise> result = new MutableLiveData<>();
        repository.insert(exercise);
    }


    public LiveData<List<Exercise>> getAllExercises() {
        final MutableLiveData<List<Exercise>> result = new MutableLiveData<>();
        repository.getAllExercises().observeForever(new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                result.postValue(exercises);
            }
        });

        return  result;
    }
}
