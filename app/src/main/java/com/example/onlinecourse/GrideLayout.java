package com.example.onlinecourse;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GrideLayout extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    int[] arr = {
            R.drawable.android,
            R.drawable.cs,
            R.drawable.csharp,
            R.drawable.css,
            R.drawable.react_native,
            R.drawable.reactjs,
            R.drawable.express,
            R.drawable.js,
            R.drawable.nestjs,
            R.drawable.nodejs,
            R.drawable.php,
            R.drawable.sql,
            R.drawable.vb,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gride_layout);
        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(arr);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

    }
}