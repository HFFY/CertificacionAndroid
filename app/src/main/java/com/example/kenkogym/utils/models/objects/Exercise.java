package com.example.kenkogym.utils.models.objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.kenkogym.utils.models.types.enumExercise;


@Entity(tableName = "excercise_table")
public class Exercise {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "name")
    private String name;


    @ColumnInfo(name = "type")
    private enumExercise type;

    @ColumnInfo(name = "image")
    private int image;


    public Exercise (String id,String name, enumExercise type, int image){
        this.id=id;
        this.name=name;
        this.type=type;
        this.image=image;
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

    @NonNull
    public String getId() {return id;}

    public void setId(@NonNull String id) {this.id = id; }
}

