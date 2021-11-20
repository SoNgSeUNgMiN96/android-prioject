package com.cookandroid.fragcolorexample_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTabHost;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRed,btnGreen, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRed = (Button)findViewById(R.id.btnRed);
        btnGreen = (Button)findViewById(R.id.btnGreen);
        btnBlue = (Button)findViewById(R.id.btnBlue);


        MyColorFragment fragWhite = new MyColorFragment();
        final FragmentTransaction fragmentTransaction  = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_lyout, fragWhite);
        fragmentTransaction.addToBackStack("fragWhite");
        fragmentTransaction.commit();

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("ColorSelected","red");
                MyColorFragment fragRed = new MyColorFragment();
                fragRed.setArguments(data);
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_lyout,fragRed);
                fragmentTransaction1.addToBackStack("fragRed");
                fragmentTransaction1.commit();
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("ColorSelected","green");

                MyColorFragment fragGreen = new MyColorFragment();
                fragGreen.setArguments(data);
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_lyout,fragGreen);
                fragmentTransaction1.addToBackStack("fragGreen");
                fragmentTransaction1.commit();
            }
        });
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("ColorSelected","blue");
                MyColorFragment fragBlue = new MyColorFragment();
                fragBlue.setArguments(data);
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_lyout,fragBlue);
                fragmentTransaction1.addToBackStack("fragBlue");
                fragmentTransaction1.commit();
            }
        });

    }
}
