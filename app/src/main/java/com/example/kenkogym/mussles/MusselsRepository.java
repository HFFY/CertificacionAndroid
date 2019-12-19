package com.example.kenkogym.mussles;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.mussles.local.LocalRepository;
import com.example.kenkogym.utils.models.objects.Exercise;
import com.example.kenkogym.utils.models.types.enumExercise;

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


    private void insertToDataBase(){
        Exercise ex1= new Exercise("1","Abdominales", enumExercise.ABS,1);
        Exercise ex2= new Exercise("2","Flexiones", enumExercise.ABS,2);
        Exercise ex3= new Exercise("3","Pesas", enumExercise.BICEP,3);
        Exercise ex4= new Exercise("4","Mancuernas", enumExercise.BICEP,4);
        Exercise ex5= new Exercise("5","Cuadriceps", enumExercise.LEGS,5);
        Exercise ex6= new Exercise("6","Bicicleta", enumExercise.CARDIO,6);
        Exercise ex7= new Exercise("7","Triceps", enumExercise.ARMS,7);
        Exercise ex8= new Exercise("8","Resistencia", enumExercise.BACK,8);
        insert(ex1);
        insert(ex2);
        insert(ex3);
        insert(ex4);
        insert(ex5);
        insert(ex6);
        insert(ex7);
        insert(ex8);
    }

}
