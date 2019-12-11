package com.example.kenkogym.utils;

import com.example.kenkogym.utils.models.objects.User;
import com.example.kenkogym.utils.models.types.enumUser;
import com.example.kenkogym.utils.models.userLogged;
import com.google.firebase.auth.FirebaseUser;

public class ResponseMapper {

    public static userLogged mapUserToUserLooged(FirebaseUser user) {
        if (user.getEmail().equals(Constants.USER_EMAIL_TRAINER)) {
            return new userLogged(user.getEmail(), enumUser.TRAINER);
        } else{
            return new userLogged(user.getEmail(), enumUser.STUDENT);
        }
    }
}
