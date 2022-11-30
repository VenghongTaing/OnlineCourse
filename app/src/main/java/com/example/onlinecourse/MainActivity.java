package com.example.onlinecourse;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent show_loginform = new Intent(MainActivity.this, LoginForm.class);
        //startActivity(show_loginform);
        Intent show_signupform = new Intent(MainActivity.this, Signup.class);
        Intent show_fragment = new Intent(MainActivity.this, Fragment_testing_MM.class);
        //startActivity(show_signupform);
        Intent show_dashboard = new Intent(MainActivity.this, Dashboard.class);

        Intent show_navigationform = new Intent(MainActivity.this, customNavigation.class);
        Intent show_course = new Intent(MainActivity.this, GrideLayout.class);

        startActivity(show_signupform);

    }


}