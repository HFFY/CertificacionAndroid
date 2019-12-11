package com.example.kenkogym.studentsList;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.Base;

import java.util.ArrayList;

public class StudentsListRepository implements RepositoryUserImpl {

    private static StudentsListRepository instance;

    public static StudentsListRepository getInstance() {
        if (instance == null) {
            instance = new StudentsListRepository();
        }
        return instance;
    }

    private StudentsListRepository() {
    }

//    @Override
//    public LiveData<Base> login(String email, String password) {
//        return FireBaseRepository.getInstance().login(email, password);
//    }

    @Override
    public ArrayList<Object> getUsers() {
        return ApiRepository.getInstance().getUsers();
    }

    @Override
    public LiveData<Base> getUserDetails(String uuid) {
        return null;
    }
}
