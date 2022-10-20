package com.example.onlinecourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Fragment_testing_MM extends AppCompatActivity {
    /*
     * Because in this form has two button that represent for calling the each fragments
     * Declaring object of button. When we use button in code, whe only use object only not use class but declaring object of button for make sure that object is button.
     * */
    Button firstFragmentBtn, secondFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_testing_mm);

        //using object button
        firstFragmentBtn = findViewById(R.id.fragment1btn);
        secondFragmentBtn = findViewById(R.id.fragment2btn);

        //set event on each buttons
        //OnClickListener() is interface
        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            //setOnClickListener is method
            @Override
            public void onClick(View view)
            //Onclick is method that is overrided
            //View is UI component
            //Call when is clicked.


            {
                replaceFragment(new fragment1());
            }
        });

        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new fragment2());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.framceLayout_mm, fragment);
//        fragmentTransaction.commit();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout_mm, fragment2.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
}