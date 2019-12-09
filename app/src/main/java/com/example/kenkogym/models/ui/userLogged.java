package com.example.kenkogym.models.ui;

import com.example.kenkogym.models.types.enumUser;

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
