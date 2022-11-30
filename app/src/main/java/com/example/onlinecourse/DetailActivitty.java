package com.example.onlinecourse;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivitty extends AppCompatActivity {
    ImageView imageView;
    TextView title = findViewById(R.id.name), type = findViewById(R.id.type);
    String coursetitle, coursetype;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activitty);
        imageView = findViewById(R.id.images);
        coursetitle = getIntent().getStringExtra("title");
        coursetype = getIntent().getStringExtra("type");
        image = getIntent().getIntExtra("image", 0);
        title.setText(coursetitle);
        type.setText(coursetype);
        imageView.setImageResource(image);
    }
}