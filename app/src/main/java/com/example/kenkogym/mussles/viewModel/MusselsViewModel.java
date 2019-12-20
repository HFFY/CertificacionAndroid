package com.example.kenkogym.mussles.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.mussles.MusselsRepository;
import com.example.kenkogym.utils.models.objects.Exercise;
import com.example.kenkogym.utils.models.types.enumExercise;

import java.util.List;

public class MusselsViewModel extends AndroidViewModel {

    private MusselsRepository repository;

    public MusselsViewModel(@NonNull Application application) {
        super(application);
        repository = MusselsRepository.getInstance(application);
    }

    public void registerExercise() {
        Exercise ex1= new Exercise("1","Abdominales", enumExercise.ABS,1);
        Exercise ex2= new Exercise("2","Flexiones", enumExercise.ABS,2);
        Exercise ex3= new Exercise("3","Pesas", enumExercise.BICEP,3);
        Exercise ex4= new Exercise("4","Mancuernas", enumExercise.BICEP,4);
        Exercise ex5= new Exercise("5","Cuadriceps", enumExercise.LEGS,5);
        Exercise ex6= new Exercise("6","Bicicleta", enumExercise.CARDIO,6);
        Exercise ex7= new Exercise("7","Triceps", enumExercise.ARMS,7);
        Exercise ex8= new Exercise("8","Resistencia", enumExercise.BACK,8);
        repository.insert(ex1);
        repository.insert(ex2);
        repository.insert(ex3);
        repository.insert(ex4);
        repository.insert(ex5);
        repository.insert(ex6);
        repository.insert(ex7);
        repository.insert(ex8);
    }


    public LiveData<List<Exercise>> getAllExercises() {
        return repository.getAllExercises();
    }
}
