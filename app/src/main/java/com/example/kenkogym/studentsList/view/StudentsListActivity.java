package com.example.kenkogym.studentsList.view;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kenkogym.R;
import com.example.kenkogym.utils.models.objects.User;
import com.example.kenkogym.utils.UserUtils;
//import com.google.gson.Gson;

import java.util.List;

public class StudentsListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
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
}
