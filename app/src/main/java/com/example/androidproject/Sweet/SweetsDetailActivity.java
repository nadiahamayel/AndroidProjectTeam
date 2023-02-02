package com.example.androidproject.Sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidproject.R;

public class SweetsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweets_detail);

        Intent intent = getIntent();
        int id = (int)intent.getExtras().get("sweet_id");

        SweetDet sweetDet = SweetDet.sweets[id];

        ImageView image = findViewById(R.id.sweet_image);
        image.setImageResource(sweetDet.getSweet_imageID());

        TextView txtName= findViewById(R.id.sweetName);
        TextView txtTime= findViewById(R.id.sweetTime);
        TextView txtDesc= findViewById(R.id.sweetDesc);

        txtName.setText("Sweet Name : "+sweetDet.getSweet_name());
        txtDesc.setText("Sweet Description : "+sweetDet.getSweet_description());
        txtTime.setText("Sweet Time : "+sweetDet.getSweet_time() + "min");
    }
}