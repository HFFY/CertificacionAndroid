package com.example.kenkogym.userCreation;

import java.util.ArrayList;

public class ApiRepository {


    private static ApiRepository instance;

    public static ApiRepository getInstance() {
        if (instance == null) {
            instance = new ApiRepository();
        }
        return instance;
    }


    private ApiRepository() {


    }

    public ArrayList<Object> sendUser() {
        return null;
    }

}