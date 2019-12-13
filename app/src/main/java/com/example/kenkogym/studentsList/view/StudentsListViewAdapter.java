package com.example.kenkogym.studentsList.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        Integer aux1 = userModelList.get(position).getAge();
        String aux=aux1.toString()+ " años";
        holder.textViewAge.setText(aux );
        holder.textViewName.setText(userModelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewProfile;
        TextView textViewName, textViewAge;

        public ViewHolder(View v) {
            super(v);
            imageViewProfile = v.findViewById(R.id.image_profile_icon);
            textViewName = v.findViewById(R.id.text_name_list);
            textViewAge = v.findViewById(R.id.text_age_list);
        }
    }

}
