package com.example.kenkogym.trainer;

import com.example.kenkogym.utils.FireBaseRepository;

import java.util.ArrayList;

public class TrainerRepository {
    private static TrainerRepository instance;
    private FireBaseRepository repository;
    public static TrainerRepository getInstance() {
        if (instance == null) {
            instance = new TrainerRepository();
        }
        return instance;
    }

    public TrainerRepository(){
        repository=FireBaseRepository.getInstance();
    }
    public void setExercises(ArrayList<String> exercises,Long id){
        repository.setExercises(exercises,id);
    }
}
