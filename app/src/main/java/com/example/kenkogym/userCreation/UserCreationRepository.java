package com.example.kenkogym.userCreation;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kenkogym.utils.FireBaseRepository;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class UserCreationRepository implements RepositoryCreateUserImpl {

    private static UserCreationRepository instance;
    private FirebaseAuth auth;
    private FireBaseRepository repository;

    public static UserCreationRepository getInstance() {
        if (instance == null) {
            instance = new UserCreationRepository();
        }
        return instance;
    }

    private UserCreationRepository() {
        auth = FirebaseAuth.getInstance();
        repository=FireBaseRepository.getInstance();
    }

    @Override
    public ArrayList<Object> sendUser(User newUser) {
        return ApiRepository.getInstance().sendUser();
    }

    public LiveData<Base> register(String email, String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.createUserWithEmailAndPassword(email,password ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();
                    results.postValue(new Base(user));
                } else {
                    results.postValue(new Base("Failure",
                            new NullPointerException()));
                }
            }
        });
        return results;
    }
    public void insertUser(User user){
        repository.insertUser(user);

    }
}
