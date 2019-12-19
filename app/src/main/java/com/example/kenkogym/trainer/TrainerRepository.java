package com.example.kenkogym.trainer;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.mussles.RepositoryImplRoom;
import com.example.kenkogym.mussles.local.LocalRepository;
import com.example.kenkogym.userCreation.ApiRepository;
import com.example.kenkogym.utils.FireBaseRepository;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.ArrayList;
import java.util.List;

public class TrainerRepository implements RepositoryImplRoom {
    private static TrainerRepository instance;
    private FireBaseRepository repository;
    private LocalRepository local;


    public static TrainerRepository getInstance(Application application) {
        if (instance == null) {
            instance = new TrainerRepository(application);
        }
        return instance;
    }

    public TrainerRepository(Application application){
        repository=FireBaseRepository.getInstance();
        local = new LocalRepository(application);
    }


    public void setExercises(ArrayList<String> exercises,Long id){
        repository.setExercises(exercises,id);
    }


    //Room methods, for insert Exercise and get all Excercises
    //Folder com.example.kenkogym.mussles.local
    @Override
    public void insert(Exercise exercise) {
        local.insert(exercise);
    }

    @Override
    public LiveData<List<Exercise>> getAllExercises() {
        return local.getAll();
    }
}
