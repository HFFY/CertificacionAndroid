package com.example.kenkogym.userMain.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.kenkogym.userMain.UserMainRepository;
import com.example.kenkogym.utils.models.objects.Days;

import java.util.ArrayList;

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
}
