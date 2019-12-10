package com.example.kenkogym.login.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.login.FirebaseRepository;
import com.example.kenkogym.utils.ResponseMapper;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.userLogged;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel  extends AndroidViewModel {

    private FirebaseRepository repository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = FirebaseRepository.getInstance();
    }

    public LiveData<Base> login(final String email, final String password) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        repository.login(email, password).observeForever(new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                if (base.isSuccess()) {
                    FirebaseUser user = (FirebaseUser) base.getData();
                    userLogged userLogged = ResponseMapper.mapUserToUserLooged(user);
                    result.postValue(new Base(userLogged));
                } else {
                    result.postValue(base);
                }
            }
        });
        /*
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
        }).start();*/
        return result;
    }


}
