package com.example.kenkogym.mussles;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;

public interface RepositoryImplRoom {

    //Db
    void insert(Exercise exercise);

    //Db
    LiveData<List<Exercise>> getAllExercises();
}
