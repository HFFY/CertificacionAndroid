package com.example.kenkogym.mussles.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.mussles.MusselsRepository;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;

public class MusselsViewModel extends AndroidViewModel {

    private MusselsRepository repository;

    public MusselsViewModel(@NonNull Application application) {
        super(application);
        repository = MusselsRepository.getInstance(application);
    }

    public LiveData<Exercise> registerExercise(final Exercise exercise) {
        final MutableLiveData<Exercise> result = new MutableLiveData<>();
        repository.insert(exercise);
        return result;
    }


    public LiveData<List<Exercise>> getAllExercises() {
        return repository.getAllExercises();
    }
}
