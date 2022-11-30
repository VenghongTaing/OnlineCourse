package com.example.onlinecourse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginForm extends AppCompatActivity {


    TextInputLayout email_txt, pass_txt;
    ProgressBar bar;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
/*
        //get edittext txt_username
        EditText username = (EditText) findViewById(R.id.txt_username);

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
                Intent intent = new Intent(LoginForm.this, Dashboard.class);
                startActivity(intent);
            }
        });

        //if enter on password edittext, then click btn_login
        password.setOnEditorActionListener((v, actionId, event) -> {
            findViewById(R.id.btn_login).performClick();
            return true;
        });
*/
        email_txt = (TextInputLayout) findViewById(R.id.email_login);
        pass_txt = (TextInputLayout) findViewById(R.id.pwd_login);
        bar = (ProgressBar) findViewById(R.id.progressBar_login);
        mAuth = FirebaseAuth.getInstance();


    }

    public void signinhere(View view) {
        bar.setVisibility(View.VISIBLE);
        String email = email_txt.getEditText().getText().toString().trim();
        String password = pass_txt.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            email_txt.getEditText().setError("Email is empty");
        } else if (!isValidEmail(email)) {
            email_txt.getEditText().setError("Invalid email");
        } else if (password.isEmpty()) {
            email_txt.setError(null);
            email_txt.setErrorEnabled(false);
            pass_txt.getEditText().setError("Password is empty");
        } else if (password.length() < 3) {
            pass_txt.getEditText().setError("Invalidate password");
        } else {
            pass_txt.setError(null);
            pass_txt.setErrorEnabled(false);
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginForm.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        bar.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(LoginForm.this, Dashboard.class);
                        intent.putExtra("email", mAuth.getCurrentUser().getEmail());
                        intent.putExtra("uid", mAuth.getCurrentUser().getUid());
                        email_txt.getEditText().setText("");
                        pass_txt.getEditText().setText("");
                        email_txt.getEditText().requestFocus();
                        startActivity(intent);
                    } else {
                        bar.setVisibility(View.INVISIBLE);
                        email_txt.getEditText().setText("");
                        pass_txt.getEditText().setText("");
                        Toast.makeText(getApplicationContext(), "Sorry, invalid email or password!!", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

    public void gotosignup(View view) {
        startActivity(new Intent(LoginForm.this, Signup.class));
    }

    public void reset_password(View view) {

        String email = email_txt.getEditText().getText().toString().trim();
        progressDialog.setTitle("Sending Mail");
        progressDialog.show();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter your register email id", Toast.LENGTH_LONG).show();
            return;
        }
        //bar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(LoginForm.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            progressDialog.cancel();
                            Toast.makeText(getApplicationContext(), "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }
                        //bar.setVisibility(View.GONE);
                        progressDialog.cancel();
                    }
                });

    }
}