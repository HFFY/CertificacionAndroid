package com.example.kenkogym.userMain.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.kenkogym.userMain.UserMainRepository;
import com.example.kenkogym.utils.models.objects.Days;
import com.example.kenkogym.utils.models.objects.User;

import java.util.ArrayList;
import java.util.List;

public class UserMainViewModel extends AndroidViewModel {


    private UserMainRepository repository;

    public UserMainViewModel(@NonNull Application application) {
        super(application);
        repository = repository.getInstance();
    }

    public LiveData<ArrayList<Days>> getDays() {
        final MutableLiveData<ArrayList<Days>> result = new MutableLiveData<>();
        repository.getDays().observeForever(new Observer<ArrayList<Days>>() {
            @Override
            public void onChanged(ArrayList<Days> days) {
                result.postValue(days);
            }
        });
        return result;
    }
    public LiveData<List<User>> getAllUsers(){
        final MutableLiveData<List<User>> result = new MutableLiveData<>();
        repository.getAllUsers().observeForever(new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                result.postValue(users);
            }
        });
        return result;
    }
}
