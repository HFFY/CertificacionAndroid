package com.example.kenkogym;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.kenkogym.repositoy.Repository;


import androidx.lifecycle.AndroidViewModel;

public class LoginViewModel extends AndroidViewModel{

    private Repository repository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance();
    }

}
