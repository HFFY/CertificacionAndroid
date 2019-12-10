package com.example.kenkogym.studentsList.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kenkogym.R;
import com.example.kenkogym.utils.models.objects.User;

import java.util.List;

public class StudentsListViewAdapter extends BaseAdapter {

    private Context context;
    private List<User> userList;

    public StudentsListViewAdapter(Context context, List<User> pokemonList) {
        this.context = context;
        this.userList = pokemonList;
    }
    @Override
    public int getCount() {
        return this.userList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position+1;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.user_list_item_horizontal, null); //Cual layout y principal o no.

            viewHolder.imageView = view.findViewById(R.id.imageViewPokemon);
            viewHolder.textViewName = view.findViewById(R.id.textViewName);
            viewHolder.textViewType = view.findViewById(R.id.textViewType);
            view.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) view.getTag(); //Obtener el dato reciclado
        }

        User user = this.userList.get(position);
        viewHolder.imageView.setImageResource(user.getImage());
        viewHolder.textViewName.setText(user.getName());
        viewHolder.textViewType.setText(user.getPassword());
        return view;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewType;
    }
}
