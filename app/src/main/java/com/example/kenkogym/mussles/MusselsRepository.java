package com.example.kenkogym.mussles;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.mussles.local.LocalRepository;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;

public class MusselsRepository implements RepositoryImplRoom {

    private static MusselsRepository instance;
    private LocalRepository local;

    public static MusselsRepository getInstance(Application application) {
        if (instance == null) {
            instance = new MusselsRepository(application);
        }
        return instance;
    }

    private MusselsRepository(Application application) { local = new LocalRepository(application);}


    @Override
    public void insert(Exercise exercise) {
        local.insert(exercise);
    }

    @Override
    public LiveData<List<Exercise>> getAllExercises() {
        return local.getAll();
    }
}
