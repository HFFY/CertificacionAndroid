package com.example.kenkogym.trainer.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
        return repository.getAllExercises();
    }
}
