package com.example.kenkogym.utils;

import com.example.kenkogym.Constants;
import com.example.kenkogym.models.Repository.User;
import com.example.kenkogym.models.types.enumUser;
import com.example.kenkogym.models.ui.userLogged;

public class ResponseMapper {

    public static userLogged mapUserToUserLooged(User user) {
        if (user.getEmail().equals(Constants.USER_EMAIL_TRAINER)) {
            return new userLogged(user.getEmail(), enumUser.TRAINER);
        } else{
            return new userLogged(user.getEmail(), enumUser.STUDENT);
        }
    }
}
