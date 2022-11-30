package com.example.onlinecourse;

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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

public class Signup extends AppCompatActivity {
    TextInputLayout email_signup_txt, pass_signup_txt, confirm_pass_signup_txt;
    ProgressBar bar;
    private FirebaseAuth mAuth;

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email_signup_txt = (TextInputLayout) findViewById(R.id.email);
        pass_signup_txt = (TextInputLayout) findViewById(R.id.pwd);
        confirm_pass_signup_txt = (TextInputLayout) findViewById(R.id.confirm_pwd);
        bar = (ProgressBar) findViewById(R.id.progressBar);


    }

    public void gotosignin(View view) {
        startActivity(new Intent(Signup.this, LoginForm.class));
    }

    public void signuphere(View view) {

        String email = email_signup_txt.getEditText().getText().toString().trim();
        String pass = pass_signup_txt.getEditText().getText().toString().trim();
        String confirm_pass = confirm_pass_signup_txt.getEditText().getText().toString().trim();

        if (email.isEmpty() || email.length() < 3) {
            email_signup_txt.setError("Empty email");
        } else if (!isValidEmail(email)) {
            email_signup_txt.setError("Invalid email");
        } else if (pass.isEmpty() || pass.length() < 5) {
            email_signup_txt.setError(null);
            email_signup_txt.setErrorEnabled(false);
            pass_signup_txt.setError("Empty password or require more than 5 characters");
        } else if (confirm_pass.isEmpty() || !confirm_pass.equals(pass)) {
            pass_signup_txt.setError(null);
            pass_signup_txt.setErrorEnabled(false);
            confirm_pass_signup_txt.setError("Empty or match confirm password");
        } else {
            mAuth = FirebaseAuth.getInstance();
            mAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                @Override
                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                    if (task.getResult().getSignInMethods().size() == 0) {
                        confirm_pass_signup_txt.setError(null);
                        confirm_pass_signup_txt.setErrorEnabled(false);
                        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    bar.setVisibility(View.INVISIBLE);
                                    email_signup_txt.getEditText().setText("");
                                    pass_signup_txt.getEditText().setText("");
                                    confirm_pass_signup_txt.getEditText().setText("");
                                    email_signup_txt.getEditText().requestFocus();
                                    Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_LONG).show();
                                } else {
                                    bar.setVisibility(View.VISIBLE);
                                    Toast.makeText(getApplicationContext(), "Register is not successfully", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Email already exit. Please log in!!", Toast.LENGTH_LONG).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
