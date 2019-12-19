package com.example.kenkogym.excercises;

import android.app.Application;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.kenkogym.mussles.RepositoryImplRoom;
import com.example.kenkogym.mussles.local.LocalRepository;
import com.example.kenkogym.utils.FireBaseRepository;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;



public class ExcercisesRepository implements RepositoryImplRoom {
    private static ExcercisesRepository instance;
    private FireBaseRepository repository;

    private LocalRepository local;

    public static ExcercisesRepository getInstance(Application application) {
        if (instance == null) {
            instance = new ExcercisesRepository(application);
        }
        return instance;
    }

    public ExcercisesRepository(Application application){
        repository=FireBaseRepository.getInstance();
        local= new LocalRepository(application);
    }

    public LiveData<List<String>> getExercises(Long id){
        final MutableLiveData<List<String>> result = new MutableLiveData<>();
        repository.getExercises(id).observeForever(new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                result.postValue(strings);
            }
        });
       return result;



    }

    //Room methods, for insert Exercise and get all Excercises
    //Folder com.example.kenkogym.mussles.local
    @Override
    public void insert(Exercise exercise) {
        local.insert(exercise);
    }

    @Override
    public LiveData<List<Exercise>> getAllExercises() {
        final MutableLiveData<List<Exercise>> result = new MutableLiveData<>();
        local.getAll().observeForever(new Observer<List<Exercise>>() {
            @Override
            public void onChanged(List<Exercise> exercises) {
                result.postValue(exercises);
            }
        });
        return  result;
    }
}
