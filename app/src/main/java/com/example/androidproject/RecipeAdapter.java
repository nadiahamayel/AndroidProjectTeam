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

        ImageView imageView = convertView.findViewById(R.id.imgRecipe);

        TextView txtName = convertView.findViewById(R.id.txtRecipeName);

        TextView txtDet = convertView.findViewById(R.id.txtRecipeDetails);

        imageView.setImageResource(((Recipe) getItem(position)).getImage());

        txtName.setText(getItem(position).getClass().getName());

        txtName.setText(((Recipe) getItem(position)).getDescription());


        return convertView;
    }
}
