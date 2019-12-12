package com.example.kenkogym.studentsList;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.Base;

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
    public LiveData<Base> getUsers() {
        Log.e("Repository", ApiRepository.getInstance().getUsers()+"");
        return ApiRepository.getInstance().getUsers();
    }

    @Override
    public LiveData<Base> getUserDetails(String uuid) {
        return null;
    }
}
