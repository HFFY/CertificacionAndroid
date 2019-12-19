package com.example.kenkogym.utils.models.objects;

import com.example.kenkogym.utils.models.types.enumUser;

import java.util.ArrayList;

public class User {

    /**
     * Agregado
     *          Email
     *          ID
     */
    private Long uId;
    private enumUser type;
    private String name;
    private String email;
    private String password;
    private int image;
    private int age;
    private int weight;
    private int heigh;
    private ArrayList<String> exercises;



    /**
     * No seria necesario un constructor para esta clase, solo agregar la info que tenemos en el momento.
     * En to do caso cuanto queramos recibir los objetos de la base o del mock, solo manejaremos el id del usuario, sus valores
     * y  cambios manejamos por transaccion.
     * <p>
     * Puedo estar equivocado:
     * <p>
     * En ese caso deberiamos crear otra clase solo para el login donde tendriamos solo Email, Password que busque un id y compare
     **/
    public User(enumUser type, String name,String email, String password, int age, int weight, int heigh, ArrayList<String> exercises){

        this.type=type;
        this.name=name;
        this.email=email;
        this.password=password;
        this.age=age;
        this.weight=weight;
        this.heigh=heigh;
        this.exercises=exercises;
    }
    public User(){

    }


    public Long getuId() {return uId;}

    public void setuId(Long uId) {this.uId = uId;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<String> exercises) {
        this.exercises = exercises;
    }
}
