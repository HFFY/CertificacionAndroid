package com.example.kenkogym.utils;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.Exercise;
import com.example.kenkogym.utils.models.objects.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FireBaseRepository {
    private static FireBaseRepository instance;
    private  FirebaseDatabase database;
    private static ArrayList<User> users;

    public static FireBaseRepository getInstance() {
        if (instance == null) {
            instance = new FireBaseRepository();
        }
        return instance;
    }


    private FireBaseRepository() {
        database=FirebaseDatabase.getInstance();
    }

    public  FirebaseDatabase getDatabase() {
        return database;
    }

    public LiveData<Base> login(String email, String password) {
        MutableLiveData<Base> results = new MutableLiveData<>();
        //TODO magic
        return results;
    }
    public ArrayList<User> getAllUsers(){
        DatabaseReference myRef=database.getReference("Users");
        users = new ArrayList<>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    users.add(postSnapshot.getValue(User.class));

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("Users", "Failed to read value.", error.toException());
            }
        });
        return users;
    }
    public ArrayList<Exercise> getExerciseFromUser(String userid){
        return null;
    }
}