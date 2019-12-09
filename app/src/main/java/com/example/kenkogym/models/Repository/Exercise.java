package com.example.kenkogym.models.Repository;

import com.example.kenkogym.models.types.enumExercise;

public class Exercise {
    private String name;
    private enumExercise type;
    private int image;
    public Exercise (String name, enumExercise type, int image){
        this.name=name;
        this.type=type;
        this.image=image;
    }

}
