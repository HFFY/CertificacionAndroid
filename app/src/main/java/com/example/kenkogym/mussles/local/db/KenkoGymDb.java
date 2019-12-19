package com.example.kenkogym.mussles.local.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.kenkogym.mussles.Converter;
import com.example.kenkogym.mussles.local.dao.ExerciseDao;
import com.example.kenkogym.utils.models.objects.Exercise;

@Database(entities = {Exercise.class}, version = 1)
@TypeConverters(Converter.class)
public abstract class KenkoGymDb extends RoomDatabase {

    public abstract ExerciseDao exerciseDao();

    private static volatile KenkoGymDb INSTANCE;

    static public KenkoGymDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (KenkoGymDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            KenkoGymDb.class, "KenkoGym_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
