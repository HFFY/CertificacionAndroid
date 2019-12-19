package com.example.kenkogym.excercises.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.kenkogym.excercises.ExcercisesRepository;

public class ExcercisesViewModel extends ViewModel {
    private ExcercisesRepository repository;
    public ExcercisesViewModel(){
        repository=ExcercisesRepository.getInstance();
    }
    public void getExercises( Long id){
        repository.getExercises(id);
    }
}
