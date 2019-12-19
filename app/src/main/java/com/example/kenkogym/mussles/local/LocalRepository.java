package com.example.kenkogym.mussles.local;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.mussles.local.db.KenkoGymDb;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;


public class LocalRepository {
    private KenkoGymDb db;

    public LocalRepository(Application application) {
        db = KenkoGymDb.getDatabase(application);
    }

    public void insert(final Exercise exercise) {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        db.exerciseDao().insert(exercise);
                    }
                }
        );
        thread.start();
    }


    public LiveData<List<Exercise>> getAll() {
        return db.exerciseDao().getAll();
    }
}
