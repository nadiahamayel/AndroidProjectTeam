package com.example.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter {
    private Context mContext;
    private int mResource;

    public RecipeAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Recipe> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);


        TextView txtName = convertView.findViewById(R.id.txtRecipeName);
        ImageView imageView1 = convertView.findViewById(R.id.btnDeatails);
        ImageView imageView2 = convertView.findViewById(R.id.btnEdit);
        ImageView imageView3 = convertView.findViewById(R.id.btnDelete);

        txtName.setText(getItem(position).getClass().getName());



        return convertView;
    }
}
