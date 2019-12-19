package com.example.kenkogym.excercises.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.excercises.ExcercisesRepository;

import java.util.List;

public class ExcercisesViewModel extends ViewModel {
    private ExcercisesRepository repository;
    public ExcercisesViewModel(){
        repository=ExcercisesRepository.getInstance();
    }
    public LiveData<List<String>> getExercises(Long id){
       return repository.getExercises(id);
    }
}
