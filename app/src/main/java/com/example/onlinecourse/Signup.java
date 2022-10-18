package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //id AlreadyHasAccount
        TextView AlreadyHasAccount = findViewById(R.id.alreadyHasAccount);

        //if Alreaduhasaccount is clicked push to Activity LoginForm
        AlreadyHasAccount.setOnClickListener(v -> {
            Intent show_loginform = new Intent(Signup.this, LoginForm.class);
            startActivity(show_loginform);
        });

    }
}