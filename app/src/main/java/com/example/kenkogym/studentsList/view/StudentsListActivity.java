package com.example.kenkogym.studentsList.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kenkogym.R;
import com.example.kenkogym.main.view.MainActivity;
import com.example.kenkogym.utils.models.objects.User;
import com.example.kenkogym.utils.UserUtils;
//import com.google.gson.Gson;

import java.util.List;

public class StudentsListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;
    //private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        initViews();
        final List<User> userList = UserUtils.getUsers();
        StudentsListViewAdapter adapter = new StudentsListViewAdapter(this, userList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = userList.get(position);
                Intent intent = new Intent(StudentsListActivity.this, MainActivity.class);
                //intent.putExtra(Constants.USER_SELECTED, gson.toJson(user));
                startActivity(intent);
            }
        });
        listview.setAdapter(adapter);
    }
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        listview = findViewById(R.id.listViewMyStudents);
    }

    private void initToolbar() {

    }
}
