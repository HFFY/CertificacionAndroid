package com.example.kenkogym.trainer.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.kenkogym.trainer.TrainerRepository;

import java.util.ArrayList;

public class TrainerViewModel extends ViewModel {
    private TrainerRepository repository;
    public TrainerViewModel(){
        repository=TrainerRepository.getInstance();
    }
    public void setExercises(ArrayList<String> exercises, Long id){
            repository.setExercises(exercises,id);
    }
}
