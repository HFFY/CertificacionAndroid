package com.example.kenkogym.repositoy;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.RepositoryImpl;
import com.example.kenkogym.utils.models.Base;

public class Repository implements RepositoryImpl {

    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
    }

    @Override
    public LiveData<Base> login(String email, String password) {return null;}

    @Override
    public LiveData<Base> getRoutes() {return null;}

    @Override
    public LiveData<Base> getRouteDetails(String uuid) {return null;}
}
