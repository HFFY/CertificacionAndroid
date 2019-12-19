package com.example.kenkogym.mussles;

import androidx.room.TypeConverter;

import com.example.kenkogym.utils.models.types.enumExercise;
import com.example.kenkogym.utils.models.types.enumUser;

public class Converter {

    @TypeConverter
    public static String fromEnumToString(enumExercise value) {
        if (value.equals(enumExercise.ABS)) {
            return "Abs";
        } else if (value.equals(enumExercise.BICEP)) {
            return "Bicep";
        } else if (value.equals(enumExercise.BACK)) {
            return "Back";
        } else if (value.equals(enumExercise.LEGS)) {
            return "Legs";
        } else if (value.equals(enumExercise.ARMS)) {
            return "Arms";
        } else {
            return "Cardio";
        }
    }

    @TypeConverter
    public enumExercise fromStringToEnum(String value) {
        if (value.equals("Abs")) {
            return enumExercise.ABS;
        }else if (value.equals("Bicep")) {
            return enumExercise.BICEP;
        } else if (value.equals("Back")) {
            return enumExercise.BACK;
        } else if (value.equals("Legs")) {
            return enumExercise.LEGS;
        } else if (value.equals("Arms")) {
            return enumExercise.ARMS;
        } else {
            return enumExercise.CARDIO;
        }
    }
}
