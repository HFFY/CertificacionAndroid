package com.example.kenkogym.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.utils.models.Base;

public class FireBaseRepository {
    private static FireBaseRepository instance;

    public static FireBaseRepository getInstance() {
        if (instance == null) {
            instance = new FireBaseRepository();
        }
        return instance;
    }

    private FireBaseRepository() {

    }

    public LiveData<Base> login(String email, String password) {
        MutableLiveData<Base> results = new MutableLiveData<>();
        //TODO magic
        return results;
    }
}