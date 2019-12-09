package com.example.kenkogym.utils;

import com.example.kenkogym.R;
import com.example.kenkogym.models.Repository.User;
import com.example.kenkogym.models.types.enumUser;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {
    public static List<User> getUsers() {
        List<User> Users = new ArrayList<>();
        Users.add(new User(enumUser.STUDENT, "Pedro","Pedro", R.drawable.ash_ketchum, 23,80,175));
        Users.add(new User(enumUser.STUDENT, "Pedro","Pedro", R.drawable.ash_ketchum, 23,80,175));
        Users.add(new User(enumUser.STUDENT, "Pedro","Pedro", R.drawable.ash_ketchum, 23,80,175));
        Users.add(new User(enumUser.STUDENT, "Pedro","Pedro", R.drawable.ash_ketchum, 23,80,175));
        Users.add(new User(enumUser.STUDENT, "Pedro","Pedro", R.drawable.ash_ketchum, 23,80,175));
        Users.add(new User(enumUser.STUDENT, "Pedro","Pedro", R.drawable.ash_ketchum, 23,80,175));
        Users.add(new User(enumUser.STUDENT, "Pedro","Pedro", R.drawable.ash_ketchum, 23,80,175));

        return Users;
    }
}
