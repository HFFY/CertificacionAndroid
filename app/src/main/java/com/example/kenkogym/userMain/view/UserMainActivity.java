package com.example.kenkogym.userMain.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.kenkogym.studentsList.view.StudentsListActivity;
import com.google.android.material.appbar.AppBarLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kenkogym.R;
import com.example.kenkogym.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class UserMainActivity extends AppCompatActivity {

    TextView textViewFragment,textViewStudents;
    Boolean fragmentPosition = false; // true = Days , false = profile
    Activity activity = this;

    private Map<String, Fragment> mapFragments = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        getSupportActionBar().hide();

        initFragments();
        textViewFragment = findViewById(R.id.text_menu);
        textViewStudents = findViewById(R.id.text_students);
        textViewFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragmentPosition) {
                    fragmentPosition = false;
                    loadFragment(Constants.KEY_FRAGMENT_PROFILE);
                    textViewFragment.setText("Ver días de entrenamiento");
                } else {
                    fragmentPosition = true;
                    loadFragment(Constants.KEY_FRAGMENT_DAYS);
                    textViewFragment.setText("Ver perfil de datos");
                }
            }
        });

        textViewStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity , StudentsListActivity.class);
                startActivity(intent);
            }
        });
        textViewFragment.setText("Ver días de entrenamiento");
        loadFragment(Constants.KEY_FRAGMENT_PROFILE);
    }

    private void initFragments() {
        mapFragments.put(Constants.KEY_FRAGMENT_DAYS, new UserFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_PROFILE, new ProfileFragment());
    }

    private void loadFragment(String key) {
        if (mapFragments.containsKey(key)) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, mapFragments.get(key), key)
                    .commit();
        }
    }
}
