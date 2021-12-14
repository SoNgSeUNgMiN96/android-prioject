package com.cookandroid.fragcomm3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentMain.FragmentMainListener {


    FragmentMain fragmentMain;

    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentC fragmentC;

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMain = new FragmentMain();
        fragmentB = new FragmentB();
        fragmentA = new FragmentA();
        fragmentC = new FragmentC();

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container,fragmentMain);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onInputASent(CharSequence input) {
        Bundle bundle = new Bundle();
        bundle.putString("input", input.toString());
        fragmentA.setArguments(bundle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragmentA);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    @Override
    public void onInputBSent(CharSequence input) {
        Bundle bundle = new Bundle();
        bundle.putString("input", input.toString());
        fragmentB.setArguments(bundle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragmentB);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onInputCSent(CharSequence input) {
        Bundle bundle = new Bundle();
        bundle.putString("input", input.toString());
        fragmentC.setArguments(bundle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragmentC);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}