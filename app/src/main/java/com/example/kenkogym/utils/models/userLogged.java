package com.example.kenkogym.utils.models;

import com.example.kenkogym.utils.models.types.enumUser;

public class userLogged {

    private String email;

    private enumUser type;

    public userLogged(String email, enumUser type) {
        this.email = email;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public enumUser getType() {
        return type;
    }
}
