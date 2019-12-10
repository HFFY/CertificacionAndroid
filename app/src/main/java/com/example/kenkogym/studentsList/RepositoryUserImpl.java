package com.example.kenkogym.studentsList;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.Base;

public interface RepositoryUserImpl {
    LiveData<Base> login(String email, String password);

    LiveData<Base> getUser();

    LiveData<Base> getUserDetails(String uuid);
}
