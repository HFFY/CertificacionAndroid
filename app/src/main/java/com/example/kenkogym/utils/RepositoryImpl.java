package com.example.kenkogym.utils;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.Base;


public interface RepositoryImpl {
    LiveData<Base> login(String email, String password);

    LiveData<Base> getRoutes();

    LiveData<Base> getRouteDetails(String uuid);
}
