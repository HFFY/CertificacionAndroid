package com.example.kenkogym.studentsList.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.kenkogym.studentsList.StudentsListRepository;
import com.example.kenkogym.utils.models.Base;

public class StudentsListViewModel extends ViewModel {

    private StudentsListRepository repository;

    public StudentsListViewModel() {repository = StudentsListRepository.getInstance();}

    public LiveData<Base> getUsers() {
        return repository.getUser();
    }

}
