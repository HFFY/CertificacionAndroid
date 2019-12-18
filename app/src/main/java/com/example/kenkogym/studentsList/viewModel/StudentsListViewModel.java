package com.example.kenkogym.studentsList.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.studentsList.StudentsListRepository;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;

import java.util.ArrayList;

public class StudentsListViewModel extends ViewModel {

    private StudentsListRepository repository;


    public StudentsListViewModel() {repository = StudentsListRepository.getInstance();}

    public LiveData<Base> getUsers() {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        repository.getUsers().observeForever(new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                if (base.isSuccess()) {
                    ArrayList<User> map = (ArrayList<User>) base.getData();
                   // ArrayList<User> data = ResponseMapper.mapObjectsToUser(map);

                    result.setValue(new Base(map));

                } else {
                    result.setValue(base);
                }
            }
        });

        return result;
    }
    public void tempGetUser(){
        repository.tempGetUsers();
    }
//    public User getUser(){
//        User user=createUser(getUsers().get(id));
//        return user;
//    }
//    public User createUser(Object object){
//        User user=null;
//        if(((Object[])object)[1].toString().equals("TRAINER")){
//             user = new User(((Object[])object)[0].toString(), enumUser.TRAINER,((Object[])object)[2].toString(),
//                    ((Object[])object)[3].toString(),((Object[])object)[4].toString(),Integer.parseInt(((Object[])object)[5].toString()),Integer.parseInt(((Object[])object)[6].toString())
//                    ,Integer.parseInt(((Object[])object)[7].toString()),Integer.parseInt(((Object[])object)[8].toString()));
//        }
//        else if(((Object[])object)[1].toString().equals("STUDENT")){
//            user = new User(((Object[])object)[0].toString(), enumUser.STUDENT,((Object[])object)[2].toString(),
//                    ((Object[])object)[3].toString(),((Object[])object)[4].toString(),Integer.parseInt(((Object[])object)[5].toString()),Integer.parseInt(((Object[])object)[6].toString())
//                    ,Integer.parseInt(((Object[])object)[7].toString()),Integer.parseInt(((Object[])object)[8].toString()));
//        }
//
//
//        return user;
//    }
}
