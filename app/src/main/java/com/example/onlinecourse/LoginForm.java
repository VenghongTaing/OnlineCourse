package com.example.onlinecourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        //get edittext txt_username
        EditText username = (EditText) findViewById(R.id.txt_username);
        //set username singleline
        username.setSingleLine();

        //get edittext txt_password
        EditText password = (EditText) findViewById(R.id.txt_password);

        //btn_login click event
        findViewById(R.id.btn_login).setOnClickListener(v -> {
            //get username and password
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();

            //check if username and password is correct
            if (usernameValue.equals("admin") && passwordValue.equals("admin")) {
                //go to activity_dashboard
                Intent show_menuForm = new Intent(LoginForm.this, customNavigation.class);
                startActivity(show_menuForm);
            }
        });

        //if enter on password edittext, then click btn_login
        password.setOnEditorActionListener((v, actionId, event) -> {
            findViewById(R.id.btn_login).performClick();
            return true;
        });

    }
}