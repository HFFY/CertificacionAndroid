package com.example.kenkogym.models.Repository;

import com.example.kenkogym.models.types.enumUser;

public class User {

    /**
     * Agregado
     *          Email
     *          ID
     */
    private String uId;
    private enumUser type;
    private String name;
    private String email;
    private String password;
    private int image;
    private int age;
    private int weight;
    private int high;


    /**
     * No seria necesario un constructor para esta clase, solo agregar la info que tenemos en el momento.
     * En to do caso cuanto queramos recibir los objetos de la base o del mock, solo manejaremos el id del usuario, sus valores
     * y  cambios manejamos por transaccion.
     * <p>
     * Puedo estar equivocado:
     * <p>
     * En ese caso deberiamos crear otra clase solo para el login donde tendriamos solo Email, Password que busque un id y compare
     **/
    public User(String id, enumUser type, String name,String email, String password, int image, int age, int weight, int high){
        this.uId=id;
        this.type=type;
        this.name=name;
        this.email=email;
        this.password=password;
        this.image=image;
        this.age=age;
        this.weight=weight;
        this.high=high;
    }

    public User(){

    }
    public String getuId() {return uId;}

    public void setuId(String uId) {this.uId = uId;}

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

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
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
