package com.example.kenkogym.userMain;

import androidx.lifecycle.LiveData;

import com.example.kenkogym.utils.models.objects.Days;

import java.util.ArrayList;

public interface RepositoryImplementation {
    public LiveData<ArrayList<Days>> getDays();
}
