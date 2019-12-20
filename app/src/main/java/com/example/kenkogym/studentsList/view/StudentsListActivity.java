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
import java.util.List;

import static com.example.kenkogym.userMain.view.UserMainActivity.userSelected;

//import com.google.gson.Gson;

public class StudentsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentsListViewModel studentsListViewModel;
    LinearLayoutManager linearLayoutManager;
    List<User> userList;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        getSupportActionBar().hide();

        Bundle args = getIntent().getExtras();
        if(args != null){
            userList = (List<User>) args.getSerializable("UserList");
        }

        initViews();
    }
    private void initViews() {
        recyclerView = findViewById(R.id.recycler_students);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        StudentsListViewAdapter adapter = new StudentsListViewAdapter(activity, userList);
        recyclerView.setAdapter(adapter);
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

                        } else {

                        }
                    }
                });
        return result;
    }

    public void selectStudent(User student){
        userSelected = new User();
        userSelected = student;
        onBackPressed();
    }
}
