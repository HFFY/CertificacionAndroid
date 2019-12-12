package com.example.kenkogym.studentsList.view;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kenkogym.R;
import com.example.kenkogym.studentsList.viewModel.StudentsListViewModel;
import com.example.kenkogym.utils.UserUtils;
import com.example.kenkogym.utils.models.Base;
import com.example.kenkogym.utils.models.objects.User;

import java.util.List;

//import com.google.gson.Gson;

public class StudentsListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private StudentsListViewModel studentsListViewModel;
    //private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        initViews();
        final List<User> userList = UserUtils.getUsers();
        StudentsListViewAdapter adapter = new StudentsListViewAdapter(userList);
//        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                User user = userList.get(position);
//                Intent intent = new Intent(StudentsListActivity.this, MainActivity.class);
//                //intent.putExtra(Constants.USER_SELECTED, gson.toJson(user));
//                startActivity(intent);
//            }
//        });
        recyclerView.setAdapter(adapter);
    }
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_students);
    }

    private void initToolbar() {

    }
    private LiveData<Base> getUsers(){
        studentsListViewModel = new ViewModelProvider(this).get(StudentsListViewModel.class);
        return studentsListViewModel.getUsers();
    }
}
