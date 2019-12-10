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

}
