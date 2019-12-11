package com.example.kenkogym.userCreation;

import com.example.kenkogym.utils.models.objects.User;

import java.util.ArrayList;

public class UserCreationRepository implements  RepositoryCreateUserImpl{

    private static UserCreationRepository instance;

    public static UserCreationRepository getInstance() {
        if (instance == null) {
            instance = new UserCreationRepository();
        }
        return instance;
    }


    @Override
    public ArrayList<Object> sendUser(User newUser) {
        return ApiRepository.getInstance().sendUser();
    }

}
