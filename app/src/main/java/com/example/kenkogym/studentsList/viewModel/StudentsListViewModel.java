package com.example.kenkogym.studentsList.viewModel;

import androidx.lifecycle.ViewModel;

import com.example.kenkogym.studentsList.StudentsListRepository;
import com.example.kenkogym.utils.models.objects.User;
import com.example.kenkogym.utils.models.types.enumUser;

import java.util.ArrayList;

public class StudentsListViewModel extends ViewModel {

    private StudentsListRepository repository;


    public StudentsListViewModel() {repository = StudentsListRepository.getInstance();}

    public ArrayList<Object> getUsers() {



        return repository.getUsers();
    }
    public User getUser(int id){
        User user=createUser(getUsers().get(id));
        return user;
    }
    public User createUser(Object object){
        User user=null;
        if(((Object[])object)[1].toString().equals("TRAINER")){
             user = new User(((Object[])object)[0].toString(), enumUser.TRAINER,((Object[])object)[2].toString(),
                    ((Object[])object)[3].toString(),((Object[])object)[4].toString(),Integer.parseInt(((Object[])object)[5].toString()),Integer.parseInt(((Object[])object)[6].toString())
                    ,Integer.parseInt(((Object[])object)[7].toString()),Integer.parseInt(((Object[])object)[8].toString()));
        }
        else if(((Object[])object)[1].toString().equals("STUDENT")){
            user = new User(((Object[])object)[0].toString(), enumUser.STUDENT,((Object[])object)[2].toString(),
                    ((Object[])object)[3].toString(),((Object[])object)[4].toString(),Integer.parseInt(((Object[])object)[5].toString()),Integer.parseInt(((Object[])object)[6].toString())
                    ,Integer.parseInt(((Object[])object)[7].toString()),Integer.parseInt(((Object[])object)[8].toString()));
        }


        return user;
    }
}
