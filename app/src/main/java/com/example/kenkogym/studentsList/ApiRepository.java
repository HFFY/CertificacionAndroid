package com.example.kenkogym.studentsList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.utils.Constants;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {

    private UsersApi usersAPI;
    private static ApiRepository instance;

    public static ApiRepository getInstance() {
        if (instance == null) {
            instance = new ApiRepository();
        }
        return instance;
    }

    private ApiRepository() {
        usersAPI = ApiService.createService(UsersApi.class);
    }

    public LiveData<Base> getUsers() {
        final MutableLiveData<Base> results = new MutableLiveData<>();

        usersAPI.getUsers(Constants.API_PARAM_ALT)
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                        if (response.isSuccessful()) {
                            results.postValue(new Base(response.body()));
                        } else {
                            results.postValue(new Base(response.message(), new NullPointerException()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        results.postValue(new Base("onFailure", new Exception(t)));
                    }
                });

        return results;
    }
}