package com.example.kenkogym.excercises;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.FireBaseRepository;

import java.util.List;

public class ExcercisesRepository {
    private static ExcercisesRepository instance;
    private FireBaseRepository repository;
    public static ExcercisesRepository getInstance() {
        if (instance == null) {
            instance = new ExcercisesRepository();
        }
        return instance;
    }

    public ExcercisesRepository(){
        repository=FireBaseRepository.getInstance();
    }

    public LiveData<List<String>> getExercises(Long id){
       return repository.getExercises(id);
    }
}
