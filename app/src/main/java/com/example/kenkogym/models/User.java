package com.example.kenkogym.models;

public class User {
    private enumType tipo;
    private String name;
    private String password;

    public User(enumType tipo,String name, String password){
        this.tipo=tipo;
        this.name=name;
        this.password=password;
    }

    public enumType getTipo() {
        return tipo;
    }

    public void setTipo(enumType tipo) {
        this.tipo = tipo;
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
