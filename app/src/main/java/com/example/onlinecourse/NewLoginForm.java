package com.example.onlinecourse;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewLoginForm extends AppCompatActivity {
    CheckBox check_showPass;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_login_form);

        check_showPass = findViewById(R.id.checkShowPass);
        password = findViewById(R.id.password);

        check_showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    //Toast.makeText(getApplicationContext(), "Hide password", Toast.LENGTH_SHORT).show();
                } else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //Toast.makeText(getApplicationContext(), "show password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //get edittext txt_username
        EditText username = (EditText) findViewById(R.id.emaill);
        //set username singleline
        username.setSingleLine();

        //get edittext txt_password
        EditText password = (EditText) findViewById(R.id.password);

        //btn_login click event
        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            //get username and password
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();

            //check if username and password is correct
            if (usernameValue.equals("admin") && passwordValue.equals("admin")) {
                //go to activity_dashboard
                Intent show_menuForm = new Intent(NewLoginForm.this, customNavigation.class);
                startActivity(show_menuForm);
            }
        });

        //if enter on password edittext, then click btn_login
        password.setOnEditorActionListener((v, actionId, event) -> {
            findViewById(R.id.btnLogin).performClick();
            return true;
        });
    }
}