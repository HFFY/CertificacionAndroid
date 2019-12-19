package com.example.kenkogym.trainer.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kenkogym.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TrainerExcerciseSelectionAdapter extends RecyclerView.Adapter<TrainerExcerciseSelectionAdapter.ViewHolder> {

    private List<String> userModelList;
    private Activity activity;

    public TrainerExcerciseSelectionAdapter(Activity activity, List<String> userModelList) {
        this.userModelList = userModelList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_excercise_selection_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        switch (userModelList.get(position)){
            default:
                break;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.isCheced){
                    holder.isCheced = false;
                    holder.linearLayout.setBackgroundResource(0);
                    //TODO: llamar a metodo para deseleccionar
                }else{
                    holder.isCheced = true;
                    holder.linearLayout.setBackgroundResource(R.drawable.btn_principal);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;
        TextView textViewName;
        LinearLayout linearLayout;
        Boolean isCheced;

        public ViewHolder(View v) {
            super(v);
            imageViewIcon = v.findViewById(R.id.image_trainer_exc);
            textViewName = v.findViewById(R.id.text_trainer_exc);
            linearLayout = v.findViewById(R.id.linear_trainer_exc);
            isCheced = false;
        }
    }
}

