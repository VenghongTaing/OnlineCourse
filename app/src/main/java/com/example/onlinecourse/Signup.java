package com.example.onlinecourse;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        TextView txtSignup = (TextView) findViewById(R.id.alreadyHasAccount);

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_loginForm = new Intent(Signup.this, NewLoginForm.class);
                startActivity(open_loginForm);
            }
        });

        //id AlreadyHasAccount
        TextView AlreadyHasAccount = findViewById(R.id.alreadyHasAccount);

        //if Alreaduhasaccount is clicked push to Activity LoginForm
        AlreadyHasAccount.setOnClickListener(v -> {
            Intent show_loginform = new Intent(Signup.this, NewLoginForm.class);
            startActivity(show_loginform);
        });

    }


}