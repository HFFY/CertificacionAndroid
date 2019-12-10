package com.example.kenkogym.login.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.login.LoginRepository;
import com.example.kenkogym.utils.ResponseMapper;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;
import com.example.kenkogym.utils.models.userLogged;

public class LoginViewModel  extends ViewModel {

    private LoginRepository repository;

    public LoginViewModel() {repository = LoginRepository.getInstance();}

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
