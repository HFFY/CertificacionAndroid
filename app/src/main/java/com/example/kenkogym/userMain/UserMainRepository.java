package com.example.kenkogym.userMain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.utils.FireBaseRepository;
import com.example.kenkogym.utils.models.objects.Days;
import com.example.kenkogym.utils.models.objects.User;

import java.util.ArrayList;

public class UserMainRepository implements RepositoryImplementation {

    private static UserMainRepository instance;
    private ArrayList<Days> days= new ArrayList<>();
    private Object Days;
    private static FireBaseRepository database;

    public static UserMainRepository getInstance(){
        if (instance == null) {
            instance = new UserMainRepository();
        }
        return instance;
    }

    private UserMainRepository() {
        database=FireBaseRepository.getInstance();


    }

    public LiveData<ArrayList<Days>> getDays(){
        final MutableLiveData<ArrayList<Days>> results = new MutableLiveData<>();
        results.postValue(createDays());
        return results;
    }

    private ArrayList<Days> createDays(){
        days.add(new Days(3,"Lunes", (long) 20191223));
        days.add(new Days(3,"Martes", (long) 20191224));
        days.add(new Days(3,"Miercoles", (long) 20191225));
        days.add(new Days(3,"Jueves", (long) 20191226));
        days.add(new Days(1,"Viernes", (long) 20191227));
        days.add(new Days(2,"Sabado", (long) 20191228));
        days.add(new Days(0,"Domingo", (long) 20191229));
        return days;
    }
    private ArrayList<User> getAllUsers(){
        return database.getAllUsers();
    }
}
