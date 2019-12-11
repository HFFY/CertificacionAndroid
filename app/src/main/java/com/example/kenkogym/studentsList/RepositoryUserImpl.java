package com.example.kenkogym.studentsList;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.Base;

import java.util.ArrayList;

public interface RepositoryUserImpl {


    ArrayList<Object> getUsers();

    LiveData<Base> getUserDetails(String uuid);
}
