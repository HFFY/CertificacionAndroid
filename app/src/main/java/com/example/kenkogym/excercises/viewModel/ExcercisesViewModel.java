package com.example.kenkogym.excercises.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.excercises.ExcercisesRepository;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;

public class ExcercisesViewModel extends AndroidViewModel {
    private ExcercisesRepository repository;

    public ExcercisesViewModel(@NonNull Application application){
        super(application);
        repository= ExcercisesRepository.getInstance(application);
    }
    public void getExercises( Long id){
        repository.getExercises(id);
    }


    //ROOM methods
    public LiveData<Exercise> registerExercise(final Exercise exercise) {
        final MutableLiveData<Exercise> result = new MutableLiveData<>();
        repository.insert(exercise);
        return result;
    }


    public LiveData<List<Exercise>> getAllExercises() {
        return repository.getAllExercises();
    }
}
