package com.example.kenkogym.repositoy;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.models.Base;


public interface RepositoryImpl {
    LiveData<Base> login(String email, String password);

    LiveData<Base> getRoutes();

    LiveData<Base> getRouteDetails(String uuid);
}
