package com.example.kenkogym.userMain.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.kenkogym.R;
import com.example.kenkogym.excercises.view.ExcercisesActivity;
import com.example.kenkogym.trainer.view.TrainerActivity;

import androidx.fragment.app.Fragment;

import static com.example.kenkogym.userMain.view.UserMainActivity.isTrainer;

public class UserFragment extends Fragment implements View.OnClickListener {

    View view;
    LinearLayout linearLayoutMonday, linearLayoutThuesday, linearLayoutThirsday,
            linearLayoutWendsday, linearLayoutFriday, linearLayoutSaturday, linearLayoutSunDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.user_fragment, container, false);

        linearLayoutMonday = view.findViewById(R.id.linear_monday);
        linearLayoutThuesday = view.findViewById(R.id.linear_thusday);
        linearLayoutThirsday = view.findViewById(R.id.linear_thirdday);
        linearLayoutWendsday = view.findViewById(R.id.linear_wendsday);
        linearLayoutFriday = view.findViewById(R.id.linear_friday);
        linearLayoutSaturday = view.findViewById(R.id.linear_saturday);
        linearLayoutSunDay = view.findViewById(R.id.linear_sunday);

        linearLayoutMonday.setOnClickListener(this);
        linearLayoutThuesday.setOnClickListener(this);
        linearLayoutThirsday.setOnClickListener(this);
        linearLayoutWendsday.setOnClickListener(this);
        linearLayoutFriday.setOnClickListener(this);
        linearLayoutSaturday.setOnClickListener(this);
        linearLayoutSunDay.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View viewClick) {
        switch (viewClick.getId()){
            case R.id.linear_monday:
            case R.id.linear_thusday:
            case R.id.linear_thirdday:
            case R.id.linear_wendsday:
            case R.id.linear_friday:
            case R.id.linear_saturday:
            case R.id.linear_sunday:
                Intent intent;
                if(isTrainer){
                    intent = new Intent(getActivity() , TrainerActivity.class);
                }else{
                    intent = new Intent(getActivity() , ExcercisesActivity.class);
                }
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewClick.getId());
        }
    }
}
