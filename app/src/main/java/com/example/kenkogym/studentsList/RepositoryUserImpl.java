package com.example.kenkogym.studentsList;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.Base;

public interface RepositoryUserImpl {


    LiveData<Base> getUsers();

    LiveData<Base> getUserDetails(String uuid);
}
