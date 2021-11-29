package com.cookandroid.fragcomm3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentMain.FragmentMainListener ,FragmentA.FragmentAListener , FragmentB.FragmentBListener {


    FragmentA fragmentA;
    FragmentB fragmentB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.,fragmentMain);
        fragmentTransaction.add(R.id.container_b,fragmentB);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentB.updateFragBEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentB.updateFragBEditText(input);
    }

    @Override
    public void onInputCSent(CharSequence input) {
        fragmentB.updateFragBEditText(input);
    }

    @Override
    public void onInputBSent(CharSequence input) {
        fragmentA.updateFragAEditText(input);
    }

}
