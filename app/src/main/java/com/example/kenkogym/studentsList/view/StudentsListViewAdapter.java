package com.example.kenkogym.studentsList.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kenkogym.R;
import com.example.kenkogym.utils.models.objects.User;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class StudentsListViewAdapter extends RecyclerView.Adapter<StudentsListViewAdapter.ViewHolder> {

    private List<User> userModelList;
    private Activity activity;

    public StudentsListViewAdapter(Activity activity, List<User> userModelList) {
        this.userModelList = userModelList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Integer aux1 = userModelList.get(position).getAge();
        String aux=aux1.toString()+ " años";
        holder.textViewAge.setText(aux );
        holder.textViewName.setText(userModelList.get(position).getName());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((StudentsListActivity) activity).selectStudent(userModelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewProfile;
        TextView textViewName, textViewAge;
        LinearLayout linearLayout;

        public ViewHolder(View v) {
            super(v);
            imageViewProfile = v.findViewById(R.id.image_profile_icon);
            textViewName = v.findViewById(R.id.text_name_list);
            textViewAge = v.findViewById(R.id.text_age_list);
            linearLayout = v.findViewById(R.id.linear_student_list);
        }
    }

}
