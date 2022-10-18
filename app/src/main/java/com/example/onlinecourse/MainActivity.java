package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent show_loginform = new Intent(MainActivity.this, LoginForm.class);
//        Intent show_signupform = new  Intent(MainActivity.this, Signup.class);
//        startActivity(show_signupform);

        //start activity with dashboard
        Intent show_dashboard = new Intent(MainActivity.this, Dashboard.class);
        startActivity(show_dashboard);

    }


}