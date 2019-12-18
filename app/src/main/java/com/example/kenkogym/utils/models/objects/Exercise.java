package com.example.kenkogym.utils.models.objects;

import com.example.kenkogym.utils.models.types.enumExercise;

public class Exercise {
    private String name;
    private enumExercise type;
    private int image;
    public Exercise (String name, enumExercise type, int image){
        this.name=name;
        this.type=type;
        this.image=image;
    }
    public Exercise(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enumExercise getType() {
        return type;
    }

    public void setType(enumExercise type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
