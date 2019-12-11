package com.example.kenkogym.userCreation.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.kenkogym.userCreation.UserCreationRepository;
import com.example.kenkogym.utils.models.objects.User;

import java.util.ArrayList;

public class UserCreationViewModel extends ViewModel {

    private UserCreationRepository repository;

    public UserCreationViewModel() {repository = UserCreationRepository.getInstance();}


    public ArrayList<Object> createUser(User newUser){

        return repository.sendUser(newUser);
    }

}
