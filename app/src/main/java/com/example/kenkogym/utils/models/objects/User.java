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
    private ArrayList<Days> days;



    /**
     * No seria necesario un constructor para esta clase, solo agregar la info que tenemos en el momento.
     * En to do caso cuanto queramos recibir los objetos de la base o del mock, solo manejaremos el id del usuario, sus valores
     * y  cambios manejamos por transaccion.
     * <p>
     * Puedo estar equivocado:
     * <p>
     * En ese caso deberiamos crear otra clase solo para el login donde tendriamos solo Email, Password que busque un id y compare
     **/
    public User(Long id, enumUser type, String name,String email, String password, int image, int age, int weight, int heigh){
        this.uId=id;
        this.type=type;
        this.name=name;
        this.email=email;
        this.password=password;
        this.image=image;
        this.age=age;
        this.weight=weight;
        this.heigh=heigh;
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

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public ArrayList<Days> getDays() {
        return days;
    }

    public void setDays(ArrayList<Days> days) {
        this.days = days;
    }
}
