package com.example.kenkogym.userCreation;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;

import java.util.ArrayList;

public interface RepositoryCreateUserImpl {

    ArrayList<Object>  sendUser(User newUser);

}
