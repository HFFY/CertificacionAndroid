package com.example.kenkogym.userCreation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserCreationRepository implements  RepositoryCreateUserImpl{

    private static UserCreationRepository instance;
    private FirebaseAuth auth;

    public static UserCreationRepository getInstance() {
        if (instance == null) {
            instance = new UserCreationRepository();
        }
        return instance;
    }

    private UserCreationRepository() {
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public ArrayList<Object> sendUser(User newUser) {
        return ApiRepository.getInstance().sendUser();
    }

    public LiveData<Base> register(String email, String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.createUserWithEmailAndPassword(email, password);
        return results;
    }
}
