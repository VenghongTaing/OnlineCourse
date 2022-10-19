package com.example.onlinecourse;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private FloatingActionButton Fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent show_loginform = new Intent(MainActivity.this, NewLoginForm.class);
        Intent show_signupform = new Intent(MainActivity.this, Signup.class);
        Intent show_menuForm = new Intent(MainActivity.this, customNavigation.class);
        startActivity(show_menuForm);
        addListenerOnButtonClick();

        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        Fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        Fab_add.setOnClickListener(v -> {
            Intent push_dashboard = new  Intent(MainActivity.this, Dashboard.class);
            startActivity(push_dashboard);
        });
    }

    public void addListenerOnButtonClick() {


    }
    //Set the menu to the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getSupportActionBar().setTitle("Student Management System");
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
}