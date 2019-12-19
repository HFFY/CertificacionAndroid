package com.example.kenkogym.utils.models.objects;

import com.example.kenkogym.utils.models.types.enumUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private Long uId;
    private enumUser type;
    private String name;
    private String email;
    private String password;
    private int image;
    private int age;
    private Double weight;
    private Double heigh;
    private List<String> exercises;

    public User(enumUser type, String name, String email, String password, int age, Double weight, Double heigh, List<String> exercises) {

        this.type = type;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.heigh = heigh;
        this.exercises = exercises;
    }

    public User() {

    }


    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public enumUser getType() {
        return type;
    }

    public void setType(enumUser type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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

    public Double getHeigh() {
        return heigh;
    }

    public void setHeigh(Double heigh) {
        this.heigh = heigh;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
    }
}
