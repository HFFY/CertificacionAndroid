package com.example.kenkogym.models.Repository;

import com.example.kenkogym.models.types.enumUser;

public class User {
    private enumUser type;
    private String name;
    private String password;
    private int image;
    private int age;
    private int weight;
    private int high;



    public User(enumUser type, String name, String password, int image, int age, int weight, int high){
        this.type=type;
        this.name=name;
        this.password=password;
        this.image=image;
        this.age=age;
        this.weight=weight;
        this.high=high;
    }

    public enumUser getTipo() {
        return type;
    }

    public void setTipo(enumUser tipo) {
        this.type = tipo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
