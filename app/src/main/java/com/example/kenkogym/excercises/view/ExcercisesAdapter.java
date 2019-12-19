package com.example.kenkogym.excercises.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kenkogym.R;
import com.example.kenkogym.utils.models.objects.Exercise;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ExcercisesAdapter extends RecyclerView.Adapter<ExcercisesAdapter.ViewHolder> {

    private List<Exercise> userModelList;
    private Activity activity;

    public ExcercisesAdapter(Activity activity, List<Exercise> userModelList) {
        this.userModelList = userModelList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.excercises_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

//        switch (userModelList.get(position)){
//            default:
//                break;
//        }
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;
        TextView textViewName;

        public ViewHolder(View v) {
            super(v);
            imageViewIcon = v.findViewById(R.id.image_exc);
            textViewName = v.findViewById(R.id.text_exc);
        }
    }
}
