package com.example.kenkogym.studentsList.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kenkogym.R;
import com.example.kenkogym.studentsList.viewModel.StudentsListViewModel;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;

import java.util.ArrayList;

//import com.google.gson.Gson;

public class StudentsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentsListViewModel studentsListViewModel;
    LinearLayoutManager linearLayoutManager;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        getSupportActionBar().hide();
        initViews();
        getUsers();
    }
    private void initViews() {
        recyclerView = findViewById(R.id.recycler_students);
    }

    private LiveData<Base> getUsers(){
        studentsListViewModel = new ViewModelProvider(this).get(StudentsListViewModel.class);
        studentsListViewModel.tempGetUser();
        final MutableLiveData<Base> result = new MutableLiveData<>();
        studentsListViewModel.getUsers().observe(this, new Observer<Base>() {
                    @Override
                    public void onChanged(Base base) {

                        if (base.isSuccess()) {
                            ArrayList<User> list = (ArrayList<User>) base.getData();
                            linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(linearLayoutManager);
                            StudentsListViewAdapter adapter = new StudentsListViewAdapter(activity, list);
                            recyclerView.setAdapter(adapter);
                        } else {

                        }
                    }
                });
        return result;
    }

    public void selectStudent(String id){
        //TODO: redireccionar y cargar UserMain
    }
}
