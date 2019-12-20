package com.example.kenkogym.userCreation.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.userCreation.UserCreationRepository;
import com.example.kenkogym.utils.ResponseMapper;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;
import com.example.kenkogym.utils.models.userLogged;
import com.google.firebase.auth.FirebaseUser;

public class UserCreationViewModel extends ViewModel {

    private UserCreationRepository repository;

    public UserCreationViewModel() {repository = UserCreationRepository.getInstance();}


    public LiveData<Base> createUser(String email, String passwod){
        final MutableLiveData<Base> result = new MutableLiveData<>();

        repository.register(email, passwod).observeForever(new Observer<Base>() {
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

    public void insertUser(User user){
        repository.insertUser(user);
    }

}
