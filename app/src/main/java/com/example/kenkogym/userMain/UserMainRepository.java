package com.example.kenkogym.userMain;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.userCreation.RepositoryCreateUserImpl;
import com.example.kenkogym.utils.models.objects.Days;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class UserMainRepository implements RepositoryImplementation {

    private static UserMainRepository instance;
    private ArrayList<Days> days= new ArrayList<>();
    private Object Days;

    public static UserMainRepository getInstance(){
        if (instance == null) {
            instance = new UserMainRepository();
        }
        return instance;
    }

    private UserMainRepository() {  }

    public LiveData<ArrayList<Days>> getDays(){
        //createDays();
        final MutableLiveData<ArrayList<Days>> results = new MutableLiveData<>();
        /*for(Days myDay : createDays()){
            results.postValue(myDay);
        }*/
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
}
