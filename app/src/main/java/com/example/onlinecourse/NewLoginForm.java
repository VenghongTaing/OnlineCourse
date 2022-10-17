package com.example.onlinecourse;

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
        setContentView(R.layout.activity_new_login_form);
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
    }
}