package com.example.kenkogym.login.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

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

        return result;
    }


}
