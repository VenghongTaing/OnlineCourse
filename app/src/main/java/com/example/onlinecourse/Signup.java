package com.example.onlinecourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView txtSignup = (TextView) findViewById(R.id.alreadyHasAccount);
        String test = "Hello world";
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_loginForm = new Intent(Signup.this, LoginForm.class);
                startActivity(open_loginForm);
            }
        });
    }


}