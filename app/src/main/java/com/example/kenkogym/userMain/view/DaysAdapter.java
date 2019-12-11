package com.example.kenkogym.userMain.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kenkogym.R;
import com.example.kenkogym.studentsList.view.StudentsListViewAdapter;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DaysAdapter extends RecyclerView.Adapter<StudentsListViewAdapter.ViewHolder> {

        private List<String> userModelList;

        public DaysAdapter(List<String> userModelList) {
            this.userModelList = userModelList;
        }

        @Override
        public StudentsListViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.days_item, parent, false);
            StudentsListViewAdapter.ViewHolder viewHolder = new StudentsListViewAdapter.ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(StudentsListViewAdapter.ViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return userModelList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View v) {
                super(v);
            }
        }

    }
