package com.example.kenkogym.excercises.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.kenkogym.excercises.ExcercisesRepository;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;
import java.util.Observable;


public class ExcercisesViewModel extends AndroidViewModel {
    private ExcercisesRepository repository;

    public ExcercisesViewModel(@NonNull Application application){
        super(application);
        repository= ExcercisesRepository.getInstance(application);
    }
    public LiveData<List<String>> getExercises(Long id){
       return repository.getExercises(id);
    }


    //ROOM methods
    public LiveData<Exercise> registerExercise(final Exercise exercise) {
        final MutableLiveData<Exercise> result = new MutableLiveData<>();
        repository.insert(exercise);
        return result;
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
