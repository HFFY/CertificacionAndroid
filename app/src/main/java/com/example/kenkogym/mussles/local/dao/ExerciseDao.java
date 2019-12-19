package com.example.kenkogym.mussles.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Exercise exercise);


    @Query("SELECT * from excercise_table ")
    LiveData<List<Exercise>> getAll();
}
