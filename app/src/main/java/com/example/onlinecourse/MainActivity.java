package com.example.onlinecourse;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent show_loginform = new Intent(MainActivity.this, NewLoginForm.class);
        Intent show_signupform = new Intent(MainActivity.this, Signup.class);
        Intent show_menuForm = new Intent(MainActivity.this, customNavigation.class);
        startActivity(show_menuForm);
        addListenerOnButtonClick();


    }

    public void addListenerOnButtonClick() {


    }

}