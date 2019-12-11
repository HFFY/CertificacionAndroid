package com.example.kenkogym.studentsList.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kenkogym.R;
import com.example.kenkogym.utils.models.objects.User;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class StudentsListViewAdapter extends RecyclerView.Adapter<StudentsListViewAdapter.ViewHolder> {

        private List<User> userModelList;

        public StudentsListViewAdapter(List<User> userModelList) {
            this.userModelList = userModelList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
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
