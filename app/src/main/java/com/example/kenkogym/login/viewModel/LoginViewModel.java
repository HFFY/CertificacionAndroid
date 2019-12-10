package com.example.kenkogym.login.viewModel;

import com.example.kenkogym.repositoy.Repository;
import com.example.kenkogym.utils.ResponseMapper;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.Repository.User;
import com.example.kenkogym.utils.models.userLogged;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel  extends ViewModel {

    private Repository repository;

    public LoginViewModel() {
        repository = Repository.getInstance();
    }

    public LiveData<Base> login(final String email, final String password) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    User user = new User();
                    user.setuId("1");
                    user.setEmail(email);

                    userLogged userLogged = ResponseMapper.mapUserToUserLooged(user);
                    result.postValue(new Base(userLogged));
                } catch (InterruptedException ex) {
                    result.postValue(new Base("Interrupted", ex));
                }
            }
        }).start();
        return result;
    }

}
