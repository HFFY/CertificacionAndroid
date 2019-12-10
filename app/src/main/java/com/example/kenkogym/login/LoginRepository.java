package com.example.kenkogym.login;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.RepositoryImpl;
import com.example.kenkogym.utils.models.Base;

public class LoginRepository  implements RepositoryImpl {

    private static LoginRepository instance;

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    private LoginRepository() {
    }

    @Override
    public LiveData<Base> login(String email, String password) {
        return null;
    }

    @Override
    public LiveData<Base> getRoutes() {
        return null;
    }

    @Override
    public LiveData<Base> getRouteDetails(String uuid) {
        return null;
    }
}
