package com.example.kenkogym.excercises;

import com.example.kenkogym.utils.FireBaseRepository;

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
    public void getExercises(Long id){
        repository.getExercises(id);
    }
}
